package com.rosal.rosal730friand;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements HeadlineListFragment.OnHeadlineSelectedListener {

    private int[] newsImages = {
            R.drawable.president,
            R.drawable.soccer,
            R.drawable.rain,
            R.drawable.smartphone,
            R.drawable.movie
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_news_content) != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, NewsContentFragment.newInstance(0, "Select a headline", R.drawable.news))
                    .commit();
        }
    }

    @Override
    public void onHeadlineSelected(int position, String content) {
        NewsContentFragment newsContentFragment = (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_news_content);

        if (newsContentFragment != null) {
            newsContentFragment = NewsContentFragment.newInstance(position, content, newsImages[position]);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_news_content, newsContentFragment)
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_headlines, NewsContentFragment.newInstance(position, content, newsImages[position]))
                    .addToBackStack(null)
                    .commit();
        }
    }
}