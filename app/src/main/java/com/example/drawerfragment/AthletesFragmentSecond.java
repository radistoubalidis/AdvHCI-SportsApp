package com.example.drawerfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.List;

public class AthletesFragmentSecond extends Fragment {
    FragmentManager fm;
    FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_athletes_second,container,false);
        Button all = view.findViewById(R.id.showAll);
        Button byNat = view.findViewById(R.id.byNat);
        Button bySport = view.findViewById(R.id.bySport);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.container_fragment,new ShowAthletes());
                ft.commit();
            }
        });
        byNat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.container_fragment,new ShowAthletesByNationality());
                ft.commit();
            }
        });
        bySport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.container_fragment,new ShowAthletesBySport());
                ft.commit();
            }
        });
        return view;
    }
}
