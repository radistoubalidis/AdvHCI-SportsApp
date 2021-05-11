package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShowTeamsByNationality extends Fragment {
    View view;
    Spinner spinner;
    TextView teams;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_teams_by_nat,container, false);
        spinner =(Spinner) view.findViewById(R.id.spinner);
        teams = (TextView) view.findViewById(R.id.teams);
        String [] nats = MainActivity.db.teamDao().returnTeamNationalities();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,nats);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String country = spinner.getSelectedItem().toString();
                String result = "";
                for(Team t:MainActivity.db.teamDao().returnTeamsByNat(country)){
                    String sport = "";
                    for(Sports s:MainActivity.db.sportsDAO().getSports()){
                        if(s.getID() == t.getTID()){
                            sport=s.getName();
                        }
                    }
                    result+= "\nTeam ID: "+t.getID()+"\nSport: "+sport+"\nName: "+t.getName()+"\nStadium: "+t.getStadium()+"\nFrom: "+t.getTown()+" est."+t.getEstablishment()+"\n";
                }
                teams.setText(result);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}
