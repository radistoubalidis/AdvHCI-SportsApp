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
        for(Athletes at:MainActivity.db.athletesDAO().getAthletes()){
            System.out.println(at);
        }
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int aid = Integer.parseInt(athleteID.getText().toString());
                    for (Athletes a : MainActivity.db.athletesDAO().getAthletes()) {
                        if (a.getID() == aid){
                            int sportID = 0;
                            for(Sports s:MainActivity.db.sportsDAO().getSports()){
                                if(s.getName().equals(athleteSport.getText().toString())){
                                    sportID = s.getID();
                                    break;
                                }
                            }
                            if(sportID != 0) {
                                a.setID(aid);
                                a.setSID(sportID);
                                a.setName(athleteFirstName.getText().toString());
                                a.setSurname(athleteLastName.getText().toString());
                                a.setNationality(athleteNat.getText().toString());
                                a.setTown(athleteHometown.getText().toString());
                                MainActivity.db.athletesDAO().updateAthlete(sportID,a.getName(),a.getSurname(),a.getTown(),a.getNationality(),aid);
                                Toast.makeText(getActivity(),"Athlete Updated!", Toast.LENGTH_LONG).show();
                                athleteID.setText("");
                                athleteSport.setText("");
                                athleteFirstName.setText("");
                                athleteLastName.setText("");
                                athleteNat.setText("");
                                athleteHometown.setText("");
                                for(Athletes at:MainActivity.db.athletesDAO().getAthletes()){
                                    System.out.println(at);
                                }
                            }else{
                                Toast.makeText(getActivity(),"Something went wrong please try again!", Toast.LENGTH_LONG).show();
                            }
                            break;
                        }
                    }
                }catch(NumberFormatException e){
                    throw  e;
                }
            }
        });

        return view;
    }
}
