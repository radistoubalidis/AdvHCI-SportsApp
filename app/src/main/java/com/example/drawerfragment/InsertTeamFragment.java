package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class InsertTeamFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_insert_team,container, false);
        Button insertTeam = (Button)view.findViewById(R.id.button3);
        final EditText tid = (EditText) view.findViewById(R.id.teamid) ;
        final EditText teamSport = (EditText) view.findViewById(R.id.teamsSportName);
        final EditText teamName = (EditText) view.findViewById(R.id.teamName);
        final EditText teamStadium = (EditText) view.findViewById(R.id.teamStadiumName);
        final EditText teamNat = (EditText) view.findViewById(R.id.teamNationality);
        final EditText teamHometown = (EditText) view.findViewById(R.id.teamHometown);
        final EditText teamEst = (EditText) view.findViewById(R.id.teamEstablishment);
        insertTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int id = Integer.parseInt(tid.getText().toString());
                    int sid = 0;
                    List<Sports> sports = MainActivity.db.sportsDAO().getSports();
                    for(Sports s:sports){
                        if(s.getName().equals(teamSport.getText().toString())){
                            sid = s.getID();
                            break;
                        }
                    }
                    if(sid!=0) {
                        Team newTeam = new Team();
                        newTeam.setID(id);
                        newTeam.setTID(sid);
                        newTeam.setName(teamName.getText().toString());
                        newTeam.setStadium(teamStadium.getText().toString());
                        newTeam.setNational(teamNat.getText().toString());
                        newTeam.setTown(teamHometown.getText().toString());
                        newTeam.setEstablishment(teamEst.getText().toString());
                        MainActivity.db.teamDao().insertTeam(newTeam);
                        Toast.makeText(getActivity(), "Team Added!", Toast.LENGTH_LONG).show();
                        tid.setText("");
                        teamSport.setText("");
                        teamName.setText("");
                        teamStadium.setText("");
                        teamNat.setText("");
                        teamHometown.setText("");
                        teamEst.setText("");
                    }else{
                        Toast.makeText(getActivity(), "Something went wrong try again!", Toast.LENGTH_LONG).show();
                    }

                }catch(NumberFormatException e){
                    throw new NumberFormatException();
                }
            }
        });
        return view;
    }
}

