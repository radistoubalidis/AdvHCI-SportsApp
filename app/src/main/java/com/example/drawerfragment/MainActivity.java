package com.example.drawerfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Constants for Firestore
    public static final String SPORT_KEY = "sport";
    public static final String COUNTRY_KEY = "country";
    public static final String CITY_KEY = "city";

    //Firestore Init
    private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("androidproj-9ef3f/Agones");

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        // load default fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new MainFragment());
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.sport1) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new MainFragment());
            fragmentTransaction.commit();
        }
        if (item.getItemId() == R.id.sport2) {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new FragmentSecond());
            fragmentTransaction.commit();
        }


        return true;
    }

    //Save a match function, needs UI and text fields to function
  public void saveMatch(View view) {

        EditText cityView = (EditText) findViewById(R.id.editTextCity);
        EditText countryView = (EditText) findViewById(R.id.editTextCountry);
        EditText sportView = (EditText) findViewById(R.id.editTextSport);
        String cityText = cityView.toString();
        String countryText = countryView.toString();
        String sportText = sportView.toString();



        if (cityText.isEmpty() || countryText.isEmpty() || sportText.isEmpty()) { return; }
        Map<String, Object> dataToSave = new HashMap<String, Object>();

        //Key value pairs with constants
        dataToSave.put(CITY_KEY, cityText);
        dataToSave.put(COUNTRY_KEY, countryText);
        dataToSave.put(SPORT_KEY, sportText);
        mDocRef.set(dataToSave).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("City","Sport");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("City","Document wasn't saved");
            }
        });


    }


}