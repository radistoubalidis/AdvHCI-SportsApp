package com.example.drawerfragment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SportsDAO {
    @Query("select * from sports")
    public List<Sports> getSports();

    @Insert
    public void addSport(Sports sport);

    @Delete
    public void deleteSport(Sports sport );

    @Update
    public void updateSport(Sports sport);
}
