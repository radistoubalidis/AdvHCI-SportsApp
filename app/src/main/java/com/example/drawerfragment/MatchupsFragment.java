package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MatchupsFragment extends Fragment {
    View view ;
    FragmentManager fm;
    FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_matchups,container, false);
        Button insert = (Button) view.findViewById(R.id.insertMatchup);
        Button show = (Button) view.findViewById(R.id.showMatchups);
        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.container_fragment,new AddMatchupFragment());
                ft.commit();
            }
        });
        show.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fm = getActivity().getSupportFragmentManager();
                ft = fm.beginTransaction();
                ft.replace(R.id.container_fragment,new ShowMatchups());
                ft.commit();
            }
        });
        return view;
    }
}
