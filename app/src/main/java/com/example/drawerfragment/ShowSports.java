package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;


public class ShowSports extends Fragment {
    View view;
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_sports,container, false);
        tv = view.findViewById(R.id.query);
        List<Sports> sports = MainActivity.db.sportsDAO().getSports();
        String result = "";
        for(Sports s: sports){
            int id = s.getID();
            String name = s.getName();
            result+= "\nId:"+id+"\nName:"+name+"\n";
        }
        tv.setText(result);
        return view;
    }

    
}

