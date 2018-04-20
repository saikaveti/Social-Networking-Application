package com.demo.csc214.socialmediaapp.view;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.csc214.socialmediaapp.R;

/**
 * Created by Sailesh on 4/20/18.
 */

public class ListUsersFragment extends ListFragment{

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.list_user_layout, container, false);
        return view;
    }
}
