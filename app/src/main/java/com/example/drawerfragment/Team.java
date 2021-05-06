package com.example.drawerfragment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (tableName = "omades",
        primaryKeys = {"team_id","t_sport_id"},
        foreignKeys = {
                @ForeignKey(entity = Sports.class,
                        parentColumns = "sport_id",
                        childColumns = "t_sport_id",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        })

public class Team {
    @ColumnInfo (name = "team_id")
    private int ID;

    @ColumnInfo (name = "t_sport_id")
    private int TID;

    @ColumnInfo (name = "team_name")
    private String Name;

    @ColumnInfo (name = "team_stadium")
    private String Stadium;

    @ColumnInfo (name = "team_town")
    private String Town;

    @ColumnInfo (name = "team_national")
    private String National;

    @ColumnInfo (name = "team_establishment")
    private String Establishment;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStadium() {
        return Stadium;
    }

    public void setStadium(String stadium) {
        Stadium = stadium;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getNational() {
        return National;
    }

    public void setNational(String national) {
        National = national;
    }

    public String getEstablishment() {
        return Establishment;
    }

    public void setEstablishment(String establishment) {
        Establishment = establishment;
    }
}
