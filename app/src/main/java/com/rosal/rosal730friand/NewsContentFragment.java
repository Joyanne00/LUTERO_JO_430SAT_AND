package com.rosal.rosal730friand;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class NewsContentFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private static final String ARG_CONTENT = "content";
    private static final String ARG_IMAGE = "image";

    public static NewsContentFragment newInstance(int position, String content, int imageResId) {
        NewsContentFragment fragment = new NewsContentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_IMAGE, imageResId);
        fragment.setArguments(args);
        return fragment;
    }

    public int getShownIndex() {
        return getArguments().getInt(ARG_POSITION, 0);
    }

    public String getNewsContent() {
        return getArguments().getString(ARG_CONTENT, "No content available");
    }

    public int getNewsImageResId() {
        return getArguments().getInt(ARG_IMAGE, R.drawable.ic_launcher_background);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_content, container, false);

        TextView textView = view.findViewById(R.id.news_content_text);
        ImageView imageView = view.findViewById(R.id.news_image);

        textView.setText(getNewsContent());
        imageView.setImageResource(getNewsImageResId());

        return view;
    }
}