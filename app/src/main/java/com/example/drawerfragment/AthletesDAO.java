package com.example.drawerfragment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AthletesDAO {
    @Query("select * from athlites")
    public List<Athletes> getAthletes();

    @Insert
    public void addAthlete(Athletes athlete);

    @Delete
    public void deleteAthlete(Athletes athlete );

    @Update
    public void updateAthlete(Athletes athlete);
}
