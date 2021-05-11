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

public class ShowAthletesBySport extends Fragment {
    View view;
    Spinner spinner;
    TextView athletes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_athletes_by_sport,container,false);
        spinner =(Spinner) view.findViewById(R.id.spinner);
        athletes = (TextView) view.findViewById(R.id.athletes);
        final TextView athletes = (TextView) view.findViewById(R.id.athletes);
        String [] sports = MainActivity.db.sportsDAO().returnSportsNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,sports);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int sid=0;
                for(Sports s:MainActivity.db.sportsDAO().getSports()){
                    if(s.getName().equals(spinner.getSelectedItem().toString())){
                        sid = s.getID();
                        break;
                    }
                }
                String result = "";
                for(Athletes a:MainActivity.db.athletesDAO().returnBySportAthletes(sid)){
                    result += "\nID: "+a.getID()+"\nFull name: "+a.getName()+" "+a.getSurname()+"\nFrom: "+a.getTown()+", "+a.getNationality()+"\n";
                }
                athletes.setText(result);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}
