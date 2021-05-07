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


public class SportsFragmentMain extends Fragment{

    View view;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sports_main,container,false);
        Button action1 = (Button) view.findViewById(R.id.action1);
        action1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                System.out.println(v.getId());
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new InsertSportFragment());
                fragmentTransaction.commit();
        }
        });
        Button action2 = (Button) view.findViewById(R.id.action2);
        action2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
//                System.out.println("asdf");
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new DeleteSportFragment());
                fragmentTransaction.commit();
            }
        });
        Button action3 = (Button) view.findViewById(R.id.action3);
        action3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment,new UpdateSportFragment());
                fragmentTransaction.commit();
            }
        });
        return view;
    }

}
