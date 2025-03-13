package com.rigcpstone.multilayoutlogger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RecipeDetailActivityLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val recipeTitle = findViewById<TextView>(R.id.txtRecipeTitle)
        val recipeDetails = findViewById<TextView>(R.id.txtRecipeDetails)
        val recipeImage = findViewById<ImageView>(R.id.imgRecipe)
        val backButton = findViewById<Button>(R.id.btnBackToMain)

        // Retrieve the recipe name passed from RecipeListActivity
        val recipeName = intent.getStringExtra("RECIPE_NAME") ?: "Recipe Not Found"

        // Update UI based on selected recipe
        when (recipeName) {
            "Spaghetti" -> {
                recipeTitle.text = "Spaghetti Recipe"
                recipeDetails.text = "Ingredients:\n- Pasta\n- Tomato Sauce\n- Garlic\n\nInstructions:\n1. Boil pasta\n2. Cook sauce\n3. Mix together"
                recipeImage.setImageResource(R.drawable.spaghetti)
            }
            "Chicken Curry" -> {
                recipeTitle.text = "Chicken Curry Recipe"
                recipeDetails.text = "Ingredients:\n- Chicken\n- Coconut milk\n- Spices\n\nInstructions:\n1. Cook chicken\n2. Add spices\n3. Simmer with coconut milk"
                recipeImage.setImageResource(R.drawable.chicken_curry)
            }
            "Beef Stroganoff" -> {
                recipeTitle.text = "Beef Stroganoff Recipe"
                recipeDetails.text = "Ingredients:\n- Beef\n- Mushrooms\n- Cream\n\nInstructions:\n1. Cook beef\n2. Add mushrooms\n3. Stir in cream"
                recipeImage.setImageResource(R.drawable.beef_stroganoff)
            }
            "Vegetable Stir-fry" -> {
                recipeTitle.text = "Vegetable Stir-fry Recipe"
                recipeDetails.text = "Ingredients:\n- Broccoli\n- Carrots\n- Soy Sauce\n\nInstructions:\n1. Heat oil\n2. Add veggies\n3. Stir with sauce"
                recipeImage.setImageResource(R.drawable.vegetable_stir_fry)
            }
            "Pancakes" -> {
                recipeTitle.text = "Pancakes Recipe"
                recipeDetails.text = "Ingredients:\n- Flour\n- Eggs\n- Milk\n\nInstructions:\n1. Mix ingredients\n2. Pour batter\n3. Cook until golden brown"
                recipeImage.setImageResource(R.drawable.pancakes)
            }
            else -> {
                recipeTitle.text = "Recipe Not Found"
                recipeDetails.text = "No details available."
                recipeImage.setImageResource(R.drawable.noavail) // Use a placeholder image
            }
        }

        Log.d(TAG, "Opened Recipe: $recipeName")

        // Set Back Button Click Listener
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Closes the current activity
        }

    }
    fun goToRecipeList(view: View) {
        val intent = Intent(this, RecipeListActivity::class.java)
        startActivity(intent)
        finish() // Closes the current activity
    }
}
