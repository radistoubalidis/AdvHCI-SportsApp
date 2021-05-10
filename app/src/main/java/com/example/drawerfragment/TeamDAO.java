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

    @Query("update omades SET t_sport_id=:sid,team_name=:name,team_stadium=:stadium,team_town=:town,team_national=:nat where team_id=:id")
    public void updateTeam(int sid,String name,String stadium,String town,String nat,int id);

    @Query("select * from omades where t_sport_id= :sid")
    public List<Team> returnTeams(int sid);
}
