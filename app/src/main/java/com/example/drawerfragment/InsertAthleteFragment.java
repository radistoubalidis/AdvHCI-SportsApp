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

public class InsertAthleteFragment extends Fragment {
    View view ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insert_athlete,container,false);
        Button insert = (Button) view.findViewById(R.id.insertButton);
        final EditText athleteID = view.findViewById(R.id.athleteid);
        final EditText athleteSport = view.findViewById(R.id.athletesport);
        final EditText athleteFirstName = view.findViewById(R.id.athletefirstname);
        final EditText athleteLastName = view.findViewById(R.id.athletesurname);
        final EditText athleteNat = view.findViewById(R.id.athleteNationality);
        final EditText athleteHometown = view.findViewById(R.id.athleteHometown);
        insert.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {
                List<Sports> sports = MainActivity.db.sportsDAO().getSports();
                int sportID = 0;
                for(Sports s:sports){
                    if(s.getName().equals(athleteSport.getText().toString())){
                         sportID = s.getID();
                    }
                }
                if(sportID != 0) {
                    Athletes newAthlete = new Athletes();
                    newAthlete.setID(Integer.parseInt(athleteID.getText().toString()));
                    newAthlete.setSID(sportID);
                    newAthlete.setName(athleteFirstName.getText().toString());
                    newAthlete.setSurname(athleteLastName.getText().toString());
                    newAthlete.setNationality(athleteNat.getText().toString());
                    newAthlete.setTown(athleteHometown.getText().toString());
                    MainActivity.db.athletesDAO().addAthlete(newAthlete);
                    Toast.makeText(getActivity(),"Athlete Added!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(),"Sport wasn't found or athlete id was wrong.Try again!", Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }
}
