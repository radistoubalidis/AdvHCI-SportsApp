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

public class UpdateAthleteFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_update_athlete,container, false);
        final Button update = view.findViewById(R.id.updateButton);
        final EditText athleteID = view.findViewById(R.id.athleteid);
        final EditText athleteSport = view.findViewById(R.id.athletesport);
        final EditText athleteFirstName = view.findViewById(R.id.athletefirstname);
        final EditText athleteLastName = view.findViewById(R.id.athletesurname);
        final EditText athleteNat = view.findViewById(R.id.athleteNationality);
        final EditText athleteHometown = view.findViewById(R.id.athleteHometown);
        List<Athletes> athletes = MainActivity.db.athletesDAO().getAthletes();
        System.out.println(athletes.get(0).getName()+athletes.get(0).getID()+athletes.get(0).getSurname());
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Athletes> athletes = MainActivity.db.athletesDAO().getAthletes();
                System.out.println(athletes.get(0).getName()+athletes.get(0).getSurname());
                List<Sports> sports = MainActivity.db.sportsDAO().getSports();
                Athletes updatedAthlete = new Athletes();
                String newSport = "";
                for (Athletes a : athletes) {
                    if (a.getID() == Integer.parseInt(athleteID.getText().toString())) {
                        updatedAthlete = a;
                        break;
                    }
                }
                if (athleteSport.getText().toString() != "") {
                    newSport = athleteSport.getText().toString();
                }
                int newSportID = 0;
                if (updatedAthlete != null) {
                    if(newSport != ""){
                        for(Sports s:sports){
                            if(s.getName().equals(newSport)){
                                newSportID = s.getID();
                                break;
                            }
                        }
                        if(newSportID != 0)
                            updatedAthlete.setSID(newSportID);

                    }
                    if(athleteFirstName.getText().toString() != "")
                        updatedAthlete.setName(athleteFirstName.getText().toString());
                    if(athleteLastName.getText().toString() != "")
                        updatedAthlete.setSurname(athleteLastName.getText().toString());
                    if(athleteNat.getText().toString() != "")
                        updatedAthlete.setNationality(athleteNat.getText().toString());
                    if(athleteHometown.getText().toString() != "")
                        updatedAthlete.setTown(athleteHometown.getText().toString());
                    MainActivity.db.athletesDAO().updateAthlete(updatedAthlete);
                    Toast.makeText(getActivity(),"Athlete Updated!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(),"Couldn't find Athlete please try again!", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
