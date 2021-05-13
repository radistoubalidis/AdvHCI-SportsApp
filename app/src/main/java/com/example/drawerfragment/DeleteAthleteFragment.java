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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class DeleteAthleteFragment extends Fragment {
    View view;
    FragmentManager fm;
    FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_delete_athlete,container, false);
        Button delete = view.findViewById(R.id.deleteButton);
        final EditText firstName = view.findViewById(R.id.athletefirstName);
        final EditText lastName = view.findViewById(R.id.athletelastName);
        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                List<Athletes> athletes = MainActivity.db.athletesDAO().getAthletes();
                for(Athletes a:athletes){
                    if(a.getName().equals(firstName.getText().toString()) && a.getSurname().equals(lastName.getText().toString())){
                        MainActivity.db.athletesDAO().deleteAthlete(a);
                        Toast.makeText(getActivity(),"Athlete Deleted!", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getActivity(),"Couldn't find Athlete try Again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        return view;
    }
}
