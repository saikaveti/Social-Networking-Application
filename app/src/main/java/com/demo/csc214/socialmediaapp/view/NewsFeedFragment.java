package com.demo.csc214.socialmediaapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.csc214.socialmediaapp.R;

/**
 * Created by Sailesh on 4/20/18.
 */

public class NewsFeedFragment  extends Fragment{

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.news_feed_layout, container, false);
        return view;
    }
}
