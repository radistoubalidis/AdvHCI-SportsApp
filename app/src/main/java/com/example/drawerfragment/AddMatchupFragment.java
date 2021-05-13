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
    Spinner spinner,athletesSpinner;
    EditText et1,et2;
    TextView athleteInserted,athletes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insert_matchup, container, false);
        spinner =(Spinner) view.findViewById(R.id.spinner);
        athletesSpinner = (Spinner) view.findViewById(R.id.athleteSpinner);
        et1 = (EditText) view.findViewById(R.id.et1);
        et2 = (EditText) view.findViewById(R.id.et2);
        athleteInserted = (TextView) view.findViewById(R.id.athletesInserted);
        athletes = (TextView) view.findViewById(R.id.athletes);
        String [] sports = MainActivity.db.sportsDAO().returnSportsNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,sports);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sport = spinner.getSelectedItem().toString();
                String type = "";
                int sid = 0;
                for(Sports s: MainActivity.db.sportsDAO().getSports()){
                    if(sport.equals(s.getName())){
                        type = s.getType();
                        sid = s.getID();
                        break;
                    }
                }
                if(type.equals("Team")){
                    changeVisibility(athletesSpinner,athletes,athleteInserted,et1,et2,type);
                    List<Athletes> at = MainActivity.db.athletesDAO().returnBySportAthletes(sid);
                    String [] names = new String[at.size()];
                    for(int i=0;i<names.length;i++){
                        names[i] = at.get(i).getSurname();
                    }

                    setAthltesSpinner(athletesSpinner,names);
                    athletesSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }else{
                    changeVisibility(athletesSpinner,athletes,athleteInserted,et1,et2,type);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        athletesSpinner =(Spinner) view.findViewById(R.id.athleteSpinner);

        return view;
    }

    private void changeVisibility(Spinner athletesSpinner,TextView athletes,TextView athleInserted,EditText et1,EditText et2,String type){
        if(type.equals("Team")){
            athletesSpinner.setVisibility(View.GONE);
            athletes.setVisibility(View.GONE);
            athleInserted.setVisibility(View.GONE);
            et1.setVisibility(View.VISIBLE);
            et2.setVisibility(View.VISIBLE);
        }else{
            et1.setVisibility(View.GONE);
            et2.setVisibility(View.GONE);
            athleInserted.setVisibility(View.VISIBLE);
            athletesSpinner.setVisibility(View.VISIBLE);
            athletes.setVisibility(View.VISIBLE);
        }
    }

    private void setAthltesSpinner(Spinner athletesSpinner,String [] names){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        athletesSpinner.setAdapter(adapter);
    }

}
