package com.example.drawerfragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class ShowMatchups extends Fragment {


    //Firestore Init
    private CollectionReference colDocRef = FirebaseFirestore.getInstance().collection("Matchups");
    public int matchPage = 0;
    public String matchesText = "";


    TextView matchups;
    Button nextmatch;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_show_matchups,container, false);

        matchups = (TextView) view.findViewById(R.id.matchups);
        showMatches();

        return view;
    }

    public void showMatches() {
        Query first = colDocRef;
        first.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot documentSnapshots) {
                        List<DocumentSnapshot> documents = documentSnapshots.getDocuments();
                        for (int i = 0; i< documents.size(); i++) {
                            //documentSnapshots.getDocuments().get(matchPage);
                            matchesText += "Match " + (i) + "\n" + documents.get(i).getData().toString() + "\n\n";
                            matchups.setText(matchesText);
                        }
                    }
                });


    }

}
