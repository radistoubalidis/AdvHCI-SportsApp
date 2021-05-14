package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class AddMatchupFragment extends Fragment {
    View view;
    Spinner spinner,athletesSpinner;
    EditText et1,et2;
    TextView athleteInserted,athletes;
    ArrayList<String>  selectedAthletes = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insert_matchup, container, false);
        spinner =(Spinner) view.findViewById(R.id.spinner);
        athletesSpinner = (Spinner) view.findViewById(R.id.athleteSpinner);
        et1 = (EditText) view.findViewById(R.id.et1);
        et2 = (EditText) view.findViewById(R.id.et2);
        athleteInserted = (TextView) view.findViewById(R.id.athletesInserted);
        athletes = (TextView) view.findViewById(R.id.tv1);
        String [] sports = MainActivity.db.sportsDAO().returnSportsNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,sports);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sport = spinner.getSelectedItem().toString();
                String type = "";
                int sid = 0;
                for(Sports s: MainActivity.db.sportsDAO().getSports()){
                    if(sport.equals(s.getName())){
                        type = s.getType();
                        sid = s.getID();
                        break;
                    }
                }
                changeVisibility(athletesSpinner,athletes,athleteInserted,et1,et2,type);
                if(type.equals("Individual")){
                    ArrayList<String> names = setupIndividual(sid);


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        return view;
    }

    private void setAthletesAdded(ArrayList<String> selectedAthletes) {
        String add="";
        for(int i=0;i<selectedAthletes.size();i++){
            add += selectedAthletes.get(i);
        }
        System.out.println(add);
    }

    private ArrayList<String> setupIndividual(int sid) {
        List<Athletes> at = MainActivity.db.athletesDAO().returnBySportAthletes(sid);
        ArrayList<String> names = new ArrayList();
        for(Athletes a:at){
            names.add(a.getSurname());
        }
        setAthltesSpinner(athletesSpinner,names);
        return names;
    }


    private void changeVisibility(Spinner athletesSpinner,TextView athletes,TextView athleInserted,EditText et1,EditText et2,String type){
        if(type.equals("Team")){
            athletesSpinner.setVisibility(View.GONE);
            athletes.setVisibility(View.GONE);
            athleInserted.setVisibility(View.GONE);
            et1.setVisibility(View.VISIBLE);
            et2.setVisibility(View.VISIBLE);
        }else{
            et1.setVisibility(View.GONE);
            et2.setVisibility(View.GONE);
            athleInserted.setVisibility(View.VISIBLE);
            athletesSpinner.setVisibility(View.VISIBLE);
            athletes.setVisibility(View.VISIBLE);
        }
    }

    private void setAthltesSpinner(final Spinner athletesSpinner, ArrayList<String> names){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(),android.R.layout.simple_list_item_1,names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        athletesSpinner.setAdapter(adapter);
        athletesSpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String athlete = athletesSpinner.getSelectedItem().toString();
                String textView = athleteInserted.getText().toString();
                textView += athlete + " , " ;
                athleteInserted.setText(textView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
