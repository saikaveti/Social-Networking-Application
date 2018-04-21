package com.demo.csc214.socialmediaapp.view;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.csc214.socialmediaapp.R;
import com.demo.csc214.socialmediaapp.controller.DatabaseQueriesHandler;
import com.demo.csc214.socialmediaapp.model.Database.ProfileDatabase;
import com.demo.csc214.socialmediaapp.model.Profile.Profile;
import com.demo.csc214.socialmediaapp.model.Profile.ProfileList;

/**
 * Created by Sailesh on 4/20/18.
 */

public class ListUsersFragment extends ListFragment{

    View view;

    ProfileList list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ProfileList();

        list.profileList = DatabaseQueriesHandler.getListOfProfile(ProfileDatabase.getInstance(getContext()));

        ProfileAdapter adapter = new ProfileAdapter(getActivity(), R.layout.profile_list_adapter_view, list.profileList);

        setListAdapter(adapter);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.list_user_layout, container, false);
        return view;
    }
}
