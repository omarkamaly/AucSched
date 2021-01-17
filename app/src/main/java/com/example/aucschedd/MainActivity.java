package com.example.aucschedd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView navDrawerButton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navLayout);
        navDrawerButton = findViewById(R.id.iv_navButton);

        navDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent i1;
                Intent i2;
                Intent i3;
                Intent i4;
                switch (item.getItemId()){
                    case R.id.mItem1:
                        //item.setChecked(true);
                        i1 = new Intent(MainActivity.this, Planning.class);
                        startActivity(i1);
                        return true;
                    case (R.id.mItem2):
                        //item.setChecked(true);
                        i2 = new Intent(MainActivity.this, Advising.class);
                        startActivity(i2);
                        return true;
                    case(R.id.mItem3):
                        //item.setChecked(true);
                        i3 = new Intent(MainActivity.this, Catalog.class);
                        startActivity(i3);
                        return true;
                    case(R.id.mItem4):
                        //item.setChecked(true);
                        i4 = new Intent(MainActivity.this, ScheduleBus.class);
                        startActivity(i4);
                        return true;
                }

                return false;
            }
        });
    }
}