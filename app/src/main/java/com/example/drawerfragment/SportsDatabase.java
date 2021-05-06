package com.example.drawerfragment;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Sports.class, Athletes.class, Team.class} , version=1 ,exportSchema = false)
public abstract class SportsDatabase extends RoomDatabase {
    public abstract SportsDAO sportsDAO();
    public abstract TeamDAO teamDao();
    public abstract AthletesDAO athletesDAO();
}
