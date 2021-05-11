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

public class ShowTeams extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmnet_show_teams,container, false);
        TextView teams = view.findViewById(R.id.teams);
        String result = "";
        for(Team t:MainActivity.db.teamDao().getTeams()){
            result += "\nTeam ID: "+t.getID()+"\nName: "+t.getName()+"\nStadium: "+t.getStadium()+"\nFrom :"+t.getNational()+","+t.getTown()+" est."+t.getEstablishment()+"\n";
        }
        teams.setText(result);
        return view;
    }
}
