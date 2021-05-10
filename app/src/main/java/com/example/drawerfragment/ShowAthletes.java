package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShowAthletes extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_all_athletes,container, false);
        TextView allAthletes = view.findViewById(R.id.allAthletes);
        String result="";
        for(Athletes a:MainActivity.db.athletesDAO().getAthletes()){
            String sport = "";
            for(Sports s:MainActivity.db.sportsDAO().getSports()){
                if(s.getID() == a.getSID()){
                    sport=s.getName();
                }
            }
            result+= "\nID: "+a.getID()+"\nSport: "+sport+"\nFull name: "+a.getName()+" "+a.getSurname()+"\nFrom: "+a.getTown()+", "+a.getNationality()+"\n";
        }
        allAthletes.setText(result);
        return view;
    }
}
