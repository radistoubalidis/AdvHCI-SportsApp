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

public class DeleteSportFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_delete_sport,container,false);
        Button delete = (Button) view.findViewById(R.id.deleteButton);
        final EditText sportToDelete = view.findViewById(R.id.sportname);
        final List<Sports> sports = MainActivity.db.sportsDAO().getSports();
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              for(Sports s:sports){
                  if (s.getName().equals(sportToDelete.getText().toString())){
                      System.out.println("to brhka");
                      MainActivity.db.sportsDAO().deleteSport(s);
                      Toast.makeText(getActivity(),"Sport Deleted!", Toast.LENGTH_LONG).show();
                      sportToDelete.setText("");
                  }
              }
            }
        });
        return view;
    }
}
