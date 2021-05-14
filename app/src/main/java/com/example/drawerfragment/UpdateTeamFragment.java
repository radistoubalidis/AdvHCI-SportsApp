package com.example.drawerfragment;

import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
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
                try {
                    int id= Integer.parseInt(tid.getText().toString());
                    for (Team t : MainActivity.db.teamDao().getTeams()) {
                        if (t.getID() == id){
                            System.out.println(t);
                            int sportID = 0;
                            for(Sports s: MainActivity.db.sportsDAO().getSports()){
                                if(s.getName().equals(teamSport.getText().toString())){
                                    sportID = s.getID();
                                    break;
                                }
                            }
                            if(sportID!=0){
                                t.setID(id);
                                t.setTID(sportID);
                                t.setName(teamName.getText().toString());
                                t.setStadium(teamStadium.getText().toString());
                                t.setNational(teamNat.getText().toString());
                                t.setTown(teamHometown.getText().toString());
                                MainActivity.db.teamDao().updateTeam(t.getTID(),t.getName(),t.getStadium(),t.getTown(),t.getNational(),id);
                                Toast.makeText(getActivity(),"Team Updated!", Toast.LENGTH_LONG).show();
                                tid.setText("");
                                teamName.setText("");
                                teamSport.setText("");
                                teamStadium.setText("");
                                teamNat.setText("");
                                teamHometown.setText("");
                                for(Team te:MainActivity.db.teamDao().getTeams()){
                                    System.out.println(te);
                                }
                            }else{
                                Toast.makeText(getActivity(),"Something went wrong please try again!", Toast.LENGTH_LONG).show();
                            }
                            break;
                        }
                    }
                }catch(Exception e){
                    throw e;
                }
            }
        });
        return view;
    }
}
