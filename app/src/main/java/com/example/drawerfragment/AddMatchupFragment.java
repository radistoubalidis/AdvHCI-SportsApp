package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AddMatchupFragment extends Fragment {
    View view;
    CheckBox team,individual;
    Spinner spinner;
    EditText et1,et2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insert_matchup, container, false);
        spinner =(Spinner) view.findViewById(R.id.spinner);
        final EditText et1 = (EditText) view.findViewById(R.id.et1);
        final EditText et2 = (EditText) view.findViewById(R.id.et2);
        String [] sports = MainActivity.db.sportsDAO().returnSportsNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,sports);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sport = spinner.getSelectedItem().toString();
                String type = "";
                for(Sports s: MainActivity.db.sportsDAO().getSports()){
                    if(sport.equals(s.getName())){
                        type = s.getType();
                        break;
                    }
                }
                switch (type){
                    case "Team":
                        et1.setHint("team name 1");
                        et2.setHint("team name 2");
                        break;
                    case "Individual":
                        et1.setHint("insert athletes");
                        et1.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }



}
