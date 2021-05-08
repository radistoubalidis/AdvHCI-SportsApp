package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class AthletesFragmentSecond extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_athletes_second,container,false);
        TextView athletesTV = view.findViewById(R.id.athletes);
        List<Athletes> athletes = MainActivity.db.athletesDAO().getAthletes();
        List<Sports> sports = MainActivity.db.sportsDAO().getSports();
        String result="";
        for(Athletes a:athletes){
            String sport = "";
            for(Sports s:sports){
                if(s.getID() == a.getSID()){
                    sport=s.getName();
                }
            }
            result+= "\nID: "+a.getID()+"\nSport: "+sport+"\nFull name: "+a.getName()+" "+a.getSurname()+"\nFrom: "+a.getTown()+","+a.getNationality();
        }
        athletesTV.setText(result);
        return view;
    }
}
