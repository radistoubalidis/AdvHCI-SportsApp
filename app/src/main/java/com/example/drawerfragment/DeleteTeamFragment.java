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

public class DeleteTeamFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_delete_team,container, false);
        Button delete = (Button) view.findViewById(R.id.deleteTeam);
        final EditText teamName = (EditText) view.findViewById(R.id.teamName);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Team> teams = MainActivity.db.teamDao().getTeams();
                for(Team t:teams){
                    if(t.getName().equals(teamName.getText().toString())){
                        MainActivity.db.teamDao().deleteTeam(t);
                        break;
                    }
                }
                Toast.makeText(getActivity(), "Team Deleted!", Toast.LENGTH_LONG).show();
                teamName.setText("");
            }
        });
        return view;
    }
}
