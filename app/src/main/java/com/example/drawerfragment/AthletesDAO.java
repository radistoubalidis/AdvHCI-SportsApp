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

    @Query("update athlites SET athlete_sport_id=:sid,athelete_name=:name,athelete_sur=:sur,athlete_town=:town,athelete_nat=:nat where athlete_id= :id")
    public void updateAthlete(int sid,String name,String sur,String town,String nat,int id);

    @Query("select * from athlites where athelete_nat= :nationality")
    public List<Athletes> returnByNationalityAthletes(String nationality);

    @Query("select * from athlites where athlete_sport_id=:sid")
    public List<Athletes> returnBySportAthletes(int sid);

    @Query("select distinct athelete_nat from athlites")
    public String []  returnNationalities();
}
