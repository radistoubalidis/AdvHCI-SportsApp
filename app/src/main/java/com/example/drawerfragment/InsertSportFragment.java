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

public class InsertSportFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_isnert_sport,container,false);

        final EditText sportID = (EditText) view.findViewById(R.id.sportid);
        final EditText sportName = (EditText) view.findViewById(R.id.sportname);
        final EditText sportType = (EditText) view.findViewById(R.id.sporttype);
        Button insertSport = (Button) view.findViewById(R.id.insertSport);
        insertSport.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                    Sports newSport = new Sports();
                    String name = sportName.getText().toString();
                    String type = sportType.getText().toString();
                    System.out.println(Integer.parseInt(sportID.getText().toString()));
                    newSport.setID(Integer.parseInt(sportID.getText().toString()));
                    newSport.setName(name);
                    newSport.setType(type);
                    MainActivity.db.sportsDAO().addSport(newSport);
                    Toast.makeText(getActivity(),"Sport Added!", Toast.LENGTH_LONG).show();
                    sportID.setText("");
                    sportName.setText("");
                    sportType.setText("");
            }
        });

        return view;
    }

}
