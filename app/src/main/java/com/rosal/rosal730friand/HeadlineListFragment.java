package com.rosal.rosal730friand;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

public class HeadlineListFragment extends ListFragment {

    private OnHeadlineSelectedListener callback;

    private final String[] headlines = {
            "Headline 1: Breaking News",
            "Headline 2: Sports Update",
            "Headline 3: Weather Alert",
            "Headline 4: Technology News",
            "Headline 5: Entertainment News"
    };

    private final String[] newsContent = {
            "Breaking News Content: Good evening, and welcome to your prime-time news! We begin with breaking news tonight. In an unexpected turn of events, the President has announced new economic reforms, aimed at revitalizing small businesses across the nation. These reforms are set to provide tax breaks and access to low-interest loans for small business owners. The plan, which takes effect next month, could have a significant impact on job creation and economic recovery. We’ll keep you updated as more details emerge.",

            "Sports Update Content: And now, over to sports. In an electrifying match today, the national soccer team pulled off a stunning victory against their long-time rivals, securing a place in the finals of the championship. With a score of 3-2, the game was sealed in the final minutes by a remarkable goal from the team’s star striker. Fans are celebrating across the country, and the finals are set to take place this Sunday. In other sports news, the basketball league is heating up as teams battle it out for playoff spots. More on that later in the show.",

            "Weather Alert Content: On to weather now, and we have a severe weather alert for those of you in the northeast region. A major storm system is moving in, bringing with it heavy rain, strong winds, and the possibility of flash flooding. The storm is expected to hit late tonight, with the worst of it occurring in the early morning hours. Authorities are urging residents to stay indoors and avoid unnecessary travel. We'll keep you updated on this developing situation.",

            "Technology News Content: In tech news, the much-anticipated launch of a new AI-powered smartphone has tech enthusiasts buzzing. The device, developed by a leading tech company, boasts advanced features such as real-time language translation, enhanced virtual reality capabilities, and the ability to learn and adapt to user behavior. Early reviews are already praising its sleek design and powerful performance. Pre-orders begin next week, with a global release expected next month.",

            "Entertainment Content: And finally, in entertainment, the latest blockbuster movie has broken box office records just days after its release. The film, which features a star-studded cast and cutting-edge special effects, has captivated audiences around the world. Critics are calling it a visual masterpiece and a must-see experience. Meanwhile, on the music scene, one of the industry’s biggest names just dropped a surprise album, sending fans into a frenzy. More on that in our entertainment segment later."
    };

    private final int[] newsImages = {
            R.drawable.president,
            R.drawable.soccer,
            R.drawable.rain,
            R.drawable.smartphone,
            R.drawable.movie
    };


    public interface OnHeadlineSelectedListener {
        void onHeadlineSelected(int position, String newsContent);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            callback = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, headlines);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        callback.onHeadlineSelected(position, newsContent[position]);
    }
}