package com.example.aucschedd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    CardView cvCatalog;
    CardView cvAddToCalendar;
    CardView cvAddAssignment;
    CardView cvBusSched;
    boolean first;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = PrefConfig.readInitFromPref(this);
        Log.e("First", Boolean.toString(first));

        logo = findViewById(R.id.iv_icon);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navview);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolBar);
        //setSupportActionBar(myToolbar);
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,myToolbar
                ,R.string.navigataion_drawer_open,
                R.string.navigataion_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //currently using just to initialize db
        cvBusSched = findViewById(R.id.card1);
        cvBusSched.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleBus scheduleBus = new ScheduleBus();
                scheduleBus.show(getSupportFragmentManager(), "Schedule Bus");
            }
        });

        cvCatalog = findViewById(R.id.card2);
        cvCatalog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catalog catalog = new Catalog();
                catalog.show(getSupportFragmentManager(), "Course Catalog");
            }
        });

        cvAddToCalendar = findViewById(R.id.card3);
        cvAddToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddToCalendar addToCalendar = new AddToCalendar();
                addToCalendar.show(getSupportFragmentManager(), "Add Event");
            }
        });

        cvAddToCalendar = findViewById(R.id.card4);
        cvAddToCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAssHome addAssHome = new AddAssHome();
                addAssHome.show(getSupportFragmentManager(), "Add Event");
            }
        });

    }
    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else{
            super.onBackPressed();}
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case (R.id.mItem1): {
                //item.setChecked(true);
                i = new Intent(MainActivity.this, Courses.class);
                startActivity(i);
                return true;
            }

            case (R.id.mItem2): {
                i = new Intent(MainActivity.this, Advising.class);
                startActivity(i);
                return true;
            }
            case (R.id.mItem5):
            {
                //item.setChecked(true);
                i = new Intent(MainActivity.this, Locators.class);
                startActivity(i);
                return true;
            }
            case (R.id.mItem7):
            {
                //item.setChecked(true);
                i = new Intent(MainActivity.this, AssignmentManager.class);
                startActivity(i);
                return true;
            }
        }

        return false;
    }

}
