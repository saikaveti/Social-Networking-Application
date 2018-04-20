package com.demo.csc214.socialmediaapp.controller;

import com.demo.csc214.socialmediaapp.model.Database.ProfileDatabase;
import com.demo.csc214.socialmediaapp.model.Entities.ProfileEntity;

/**
 * Created by Sailesh on 4/20/18.
 */

public class DatabaseQueriesHandler {

    public static String[] getValuesProfileEdit(int user_id, ProfileDatabase db) {
        String[] args = new String[6];
        for (ProfileEntity profileEntity : db.profileDao().getAll()) {
            if (profileEntity.getUser_id() == user_id) {
                args[0] = profileEntity.getProfilePhoto();
                args[1] = profileEntity.getFirstName();
                args[2] = profileEntity.getLastName();
                args[3] = profileEntity.getBirthDate();
                args[4] = profileEntity.getHometown();
                args[5] = profileEntity.getBio();
            }
        }
        return args;
    }

    public static ProfileEntity getProfileEntity(int user_id, ProfileDatabase db) {
        for (ProfileEntity profileEntity : db.profileDao().getAll()) {
            if (profileEntity.getUser_id() == user_id) {
               return profileEntity;
            }
        }
        return null;
    }
}
