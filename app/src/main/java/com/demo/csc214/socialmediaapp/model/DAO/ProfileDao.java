package com.demo.csc214.socialmediaapp.model.DAO;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.demo.csc214.socialmediaapp.model.Entities.ProfileEntity;

import java.util.List;

/**
 * Created by Sailesh on 4/18/18.
 */

public interface ProfileDao {

    @Query("SELECT * FROM ProfileEntity")
    List<ProfileEntity> getAll();

    @Query("SELECT * FROM ProfileEntity WHERE user_id IN (:userIds)")
    List<ProfileEntity> loadALLByIds(int[] userIds);

    @Query("SELECT * FROM ProfileEntity WHERE user_id LIKE :userID")
    ProfileEntity getByID(int userID);

    @Query("SELECT * FROM SongEnt WHERE firstName LIKE :firstName AND " + "lastName LIKE :lastName LIMIT 1")
    ProfileEntity findByName(String songName, String artistName);

    @Insert
    void insertAll(ProfileEntity... profileEntities);


    @Delete
    void delete(ProfileEntity songEnt);

    //Deletes Table
    @Query("DELETE FROM ProfileEntity")
    void nukeTable();
}
