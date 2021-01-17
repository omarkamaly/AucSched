package com.example.aucschedd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Catalog extends AppCompatActivity {
    public String Major_select="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        Spinner spinnerCat = (Spinner) findViewById(R.id.spinnerCat);
        //Create an Array Adapter
        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(this,
                R.array.Majors,
                android.R.layout.simple_spinner_item);
        //Specify layout used when chpoices appear
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to spinner
        spinnerCat.setAdapter(adapterCat);
        //spinnerCat.setOnItemSelectedListener(this);
        Button goBtn = (Button)findViewById(R.id.goBtn);
        spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Major_select = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Major_select.equals("Computer Engineering")){
                    String ce = "http://catalog.aucegypt.edu/preview_program.php?catoid=20&poid=2942&returnto=839";
                    Uri webaddr = Uri.parse(ce);
                    Intent goToCE = new Intent(Intent.ACTION_VIEW, webaddr);

                    startActivity(goToCE);
                }else {
                    String cs = "http://catalog.aucegypt.edu/preview_program.php?catoid=20&poid=2943";
                    Uri webaddr = Uri.parse(cs);
                    Intent goToCs = new Intent(Intent.ACTION_VIEW, webaddr);

                    startActivity(goToCs);
                }
            }
        });

    }


}
