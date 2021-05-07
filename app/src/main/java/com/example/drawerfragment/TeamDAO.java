package com.example.drawerfragment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TeamDAO {
    @Query("select * from omades")
    public List<Team> getTeams();

    @Insert
    public void insertTeam(Team team);

    @Delete
    public void deleteTeam(Team team);

    @Update
    public void updateTeam(Team team);
}
