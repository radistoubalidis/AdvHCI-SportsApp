package com.example.drawerfragment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity (tableName = "athlites", //Ο πίνακας θα διαχειριστεί στον κώδικα ως athlites
        primaryKeys = {"athlete_id, athlete_sport_id"},
        foreignKeys = {
                @ForeignKey(entity = Sports.class,
                        parentColumns = "sport_id",
                        childColumns = "athlete_sport_id",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE)
        })

public class Athletes {
    @ColumnInfo (name = "athlete_id")
    private int ID;

    @ColumnInfo (name = "athlete_sport_id")
    private int SID;

    @ColumnInfo (name = "athelete_name")
    private String Name;

    @ColumnInfo (name = "athelete_sur")
    private String Surname;

    @ColumnInfo (name = "athlete_town")
    private String Town;

    @ColumnInfo (name = "athelete_nat")
    private String Nationality;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }
}
