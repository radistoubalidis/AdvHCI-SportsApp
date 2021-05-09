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

import java.util.List;

public class ShowSportsType extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_sports_type,container,false);
        List<Sports> sports = MainActivity.db.sportsDAO().getSports();
        TextView teamView = view.findViewById(R.id.team_sports);
        TextView individualView = view.findViewById(R.id.individual_sports);
        String teams = "";
        String individuals = "";
        for(Sports s: sports){
            if(s.getType().equals("Individual")){
                individuals+= "\nSport ID:"+s.getID()+"\nName:"+s.getName()+"\n";
            }else{
                teams+= "\nSport ID:"+s.getID()+"\nName:"+s.getName()+"\n";
            }
        }
        teamView.setText(teams);
        individualView.setText(individuals);
        return view;
    }
}
