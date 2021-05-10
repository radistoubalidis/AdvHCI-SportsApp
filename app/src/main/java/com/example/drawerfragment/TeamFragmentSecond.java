package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class TeamFragmentSecond extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;;
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teams_second,container,false);
        tv = view.findViewById(R.id.textView11);
        String result = "";
        for(Team t:MainActivity.db.teamDao().getTeams()){
            String sport ="";
            for(Sports s:MainActivity.db.sportsDAO().getSports()){
                if(t.getTID() == s.getID()){
                    sport = s.getName();
                }
            }
            result += "\nTeam ID: "+t.getID()+"\nName: "+t.getName()+"\nSport: "+sport+"\nStadium: "+t.getStadium()+"\nFrom: "+t.getNational()+", "+t.getTown()+", est. "+t.getEstablishment()+"\n";
        }
        tv.setText(result);
        return view;
    }
}
