package com.demo.csc214.socialmediaapp.model.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.demo.csc214.socialmediaapp.model.Entities.PostEntity;

import java.util.List;

/**
 * Created by Sailesh on 4/18/18.
 */

@Dao
public interface PostDAO {

    @Query("SELECT * FROM PostEntity")
    List<PostEntity> getAll();

    @Query("SELECT * FROM SongEnt WHERE user_id IN (:userIds)")
    List<SongEnt> loadALLByIds(int[] userIds);

    @Query("SELECT * FROM SongENT WHERE uid LIKE :userID")
    SongEnt getByID(int userID);

    @Query("SELECT * FROM SongEnt WHERE name LIKE :songName AND " + "artist LIKE :artistName LIMIT 1")
    SongEnt findByName(String songName, String artistName);

    @Insert
    void insertAll(SongEnt... songEnts);


    @Delete
    void delete(SongEnt songEnt);

    //Deletes Table
    @Query("DELETE FROM SongEnt")
    void nukeTable();
}
