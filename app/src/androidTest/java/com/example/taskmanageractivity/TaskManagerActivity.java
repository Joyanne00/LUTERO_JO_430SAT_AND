import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TaskManagerActivity extends AppCompatActivity {

    private EditText taskEditText;
    private Spinner categorySpinner;
    private Button addTaskButton;
    private ListView taskListView;
    private Button clearAllButton;

    private ArrayList<String> tasksList;
    private ArrayAdapter<String> tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_manager);

        // Initialize UI components
        taskEditText = findViewById(R.id.taskEditText);
        categorySpinner = findViewById(R.id.categorySpinner);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskListView = findViewById(R.id.taskListView);
        clearAllButton = findViewById(R.id.clearAllButton);

        // Initialize task list and adapter
        tasksList = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasksList);
        taskListView.setAdapter(tasksAdapter);

        // Load tasks from SharedPreferences
        loadTasks();

        // Set up Spinner with task categories
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.task_categories, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(spinnerAdapter);

        // Add task button click listener
        addTaskButton.setOnClickListener(view -> addTask());

        // Clear all tasks button click listener
        clearAllButton.setOnClickListener(view -> clearAllTasks());

        // Item click listener for ListView (show task details)
        taskListView.setOnItemClickListener((parent, view, position, id) -> {
            String task = tasksList.get(position);
            Toast.makeText(this, "Selected Task: " + task, Toast.LENGTH_SHORT).show();
        });

        // Long item click listener for ListView (remove task)
        taskListView.setOnItemLongClickListener((parent, view, position, id) -> {
            tasksList.remove(position);
            tasksAdapter.notifyDataSetChanged();
            saveTasks();
            return true;


            tasksAdapter = new ArrayAdapter<String>(this, R.layout.list_item_task, tasksList);
            taskListView.setAdapter(tasksAdapter);

        });
    }

    // Add new task to the list
    private void addTask() {
        String taskName = taskEditText.getText().toString().trim();
        String category = categorySpinner.getSelectedItem().toString();

        if (!taskName.isEmpty()) {
            tasksList.add(taskName + " (" + category + ")");
            tasksAdapter.notifyDataSetChanged();
            taskEditText.setText(""); // Clear the input field

            // Save updated tasks to SharedPreferences
            saveTasks();
        } else {
            Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show();
        }
    }

    // Save tasks to SharedPreferences
    private void saveTasks() {
        SharedPreferences sharedPreferences = getSharedPreferences("taskManagerPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> taskSet = new HashSet<>(tasksList);
        editor.putStringSet("tasks", taskSet);
        editor.apply();
    }

    // Load tasks from SharedPreferences
    private void loadTasks() {
        SharedPreferences sharedPreferences = getSharedPreferences("taskManagerPrefs", MODE_PRIVATE);
        Set<String> taskSet = sharedPreferences.getStringSet("tasks", new HashSet<>());
        tasksList.addAll(taskSet);
        tasksAdapter.notifyDataSetChanged();
    }

    // Clear all tasks from the list
    private void clearAllTasks() {
        tasksList.clear();
        tasksAdapter.notifyDataSetChanged();
        saveTasks(); // Save the empty task list to SharedPreferences
    }
}
