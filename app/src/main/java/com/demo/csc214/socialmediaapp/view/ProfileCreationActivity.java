package com.demo.csc214.socialmediaapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.demo.csc214.socialmediaapp.R;
import com.demo.csc214.socialmediaapp.model.Database.UserDatabase;
import com.demo.csc214.socialmediaapp.model.Entities.UserEntity;

import java.util.List;

public class ProfileCreationActivity extends AppCompatActivity {

    public final String USERID_KEY = "USER_ID_KEY";

    ImageButton mProfilePicture;

    EditText mFirstNameBox;
    EditText mLastNameBox;
    EditText mBirthdateBox;
    EditText mHometownBox;

    EditText mBio;

    Button mCreateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_creation);

        Intent profileID = getIntent();

        int user_id = profileID.getIntExtra(USERID_KEY, 0);

        mProfilePicture = findViewById(R.id.image_create_profile);



    }
}
