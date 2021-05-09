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
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int id = Integer.parseInt(athleteID.getText().toString());
                    List<Sports> sports = MainActivity.db.sportsDAO().getSports();
                    List<Athletes> athletes = MainActivity.db.athletesDAO().getAthletes();
                    Athletes updateAthlete = new Athletes();
                    int sid = 0;
                    for (Athletes a : athletes) {
                        if(id == a.getID()){
                            updateAthlete = a;
                            break;
                        }
                        for(Sports s:sports){
                            if(s.getName().equals(athleteSport.getText().toString())){
                                sid = s.getID();
                                break;
                            }
                        }
                        if(sid!=0) {
                            System.out.println(sid);
                            a.setSID(sid);
                            a.setName(athleteFirstName.getText().toString());
                            a.setSurname(athleteLastName.getText().toString());
                            a.setNationality(athleteNat.getText().toString());
                            a.setTown(athleteHometown.getText().toString());
                            System.out.println(updateAthlete.getSID()+updateAthlete.getName()+updateAthlete.getSurname()+updateAthlete.getNationality()+updateAthlete.getTown());
                            MainActivity.db.athletesDAO().updateAthlete(a);
                            Toast.makeText(getActivity(), "Athlete Updated!", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getActivity(), "Something went wrong please try again!", Toast.LENGTH_LONG).show();
                        }
                    }


                }catch (Exception e){
                    throw new NumberFormatException();
                }

            }
        });

        return view;
    }
}
