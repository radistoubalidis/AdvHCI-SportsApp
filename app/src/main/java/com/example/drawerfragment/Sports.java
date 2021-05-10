package com.example.drawerfragment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName="sports")
public class Sports {
    @PrimaryKey
    @ColumnInfo ( name = "sport_id")/*Θα χρησιμοποιηθεί το sport_id στον κώδικα και όχι το ID.
                                       Αυτό γίνεται για να κρύψουμε τα metadata της βάσης.*/
    private int ID;

    @ColumnInfo ( name = "sport_name")
    private String Name;

    @ColumnInfo ( name = "sport_type")
    private String Type;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int findByName(String name){
        if(name == this.getName())
            return this.getID();
        else
            return 0;
    }

}
