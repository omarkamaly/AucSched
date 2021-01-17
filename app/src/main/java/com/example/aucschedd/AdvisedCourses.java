package com.example.aucschedd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AdvisedCourses extends AppCompatActivity {
    private Spinner course1;
    private Spinner course2;
    private Spinner course3;
    private Spinner course4;
    private Spinner course5;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advised_courses);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        Resources resources = context.getResources();
        course1= findViewById(R.id.spinner);
        course2 = findViewById(R.id.spinner2);
        course3= findViewById(R.id.spinner3);
        course4= findViewById(R.id.spinner4);
        course5= findViewById(R.id.spinner5);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.CE, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course1.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.CE, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course2.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.CE, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course3.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.CE, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course4.setAdapter(adapter3);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.CE, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        course5.setAdapter(adapter3);
    }
}