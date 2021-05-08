package com.example.drawerfragment;

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

public class SportsFragmentSecond extends Fragment {
    FragmentManager fragmentManager;
    FragmentTransaction transaction ;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sports_second,container,false);

        Button action1 = (Button) view.findViewById(R.id.action1);
        action1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container_fragment,new ShowSports());
                transaction.commit();
            }
        });

        Button action2 = (Button) view.findViewById(R.id.action2);
        action2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                fragmentManager = getActivity().getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container_fragment,new ShowSportsType());
                transaction.commit();
            }
        });

        return view;
    }
}
