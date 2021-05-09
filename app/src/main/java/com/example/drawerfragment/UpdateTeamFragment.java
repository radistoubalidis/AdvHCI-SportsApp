package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class UpdateTeamFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_udpate_team,container, false);
        Button update = (Button)view.findViewById(R.id.updateTeam);
        final EditText tid = (EditText) view.findViewById(R.id.tid);
        final EditText teamName = (EditText) view.findViewById(R.id.teamName);
        final EditText teamSport = (EditText) view.findViewById(R.id.teamsSportName);
        final EditText teamStadium = (EditText) view.findViewById(R.id.teamStadiumName);
        final EditText teamNat = (EditText) view.findViewById(R.id.teamNat);
        final EditText teamHometown = (EditText) view.findViewById(R.id.teamHometown);
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                List<Team> teams = MainActivity.db.teamDao().getTeams();
                List<Sports> sports = MainActivity.db.sportsDAO().getSports();
                try {
                    int id = Integer.parseInt(tid.getText().toString());
                    Team updateTeam = new Team();
                    for(Team t:teams){
                        if(id == t.getID()){
                            updateTeam = t;
                            break;
                        }
                    }
                    int sid = 0;
                    for(Sports s:sports){
                        if(s.getName().equals(teamSport.getText().toString())){
                            sid = s.getID();
                        }
                    }
                    if(sid!=0){
                        updateTeam.setTID(sid);
                        updateTeam.setName(teamName.getText().toString());
                        updateTeam.setStadium(teamStadium.getText().toString());;
                        updateTeam.setNational(teamNat.getText().toString());;
                        updateTeam.setTown(teamHometown.getText().toString());;
                        System.out.println(updateTeam.getID()+updateTeam.getName());
                    }
                }catch(NumberFormatException e){
                    throw new NumberFormatException();
                }
            }
        });
        return view;
    }
}
