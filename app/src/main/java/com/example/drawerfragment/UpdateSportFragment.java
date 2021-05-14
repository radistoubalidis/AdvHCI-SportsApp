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

public class UpdateSportFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_update_sport,container,false);
        Button update = view.findViewById(R.id.update);
        final List<Sports> sports = MainActivity.db.sportsDAO().getSports();
        final EditText id = view.findViewById(R.id.sportid);
        final EditText name = view.findViewById(R.id.sportname);
        final EditText type = view.findViewById(R.id.sporttype);
        final int idValue = 0;
        update.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for(Sports s:sports){
                    if(s.getID() == Integer.parseInt(id.getText().toString())){
                        System.out.println(Integer.parseInt(id.getText().toString()));
                        if(name.getText().equals("type name here..")){
                            s.setType(type.getText().toString());
                        }else if(type.getText().toString().equals("type sport's type here..")){
                            s.setName(name.getText().toString());
                        }else{
                            s.setType(type.getText().toString());
                            s.setName(name.getText().toString());
                        }
                        MainActivity.db.sportsDAO().updateSport(s);
                        Toast.makeText(getActivity(),"Sport Updated!", Toast.LENGTH_LONG).show();
                        id.setText("");
                        name.setText("");
                        type.setText("");
                        break;
                    }
                }
            }
        });
        return view;
    }
}
;