package com.example.aucschedd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Courses extends AppCompatActivity implements AddCourse.OnAdd {
    ListView lvCourses;
    FloatingActionButton FAB;
    ImageView ivBack;
    ImageView ivWeekly;

    CourseAdapter courseAdapter;
    AddCourse addCourse;
    ArrayList<Course> courses;

    private AlarmManager alarmManager;
    private ArrayList<Intent> alarms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        Toolbar toolbar;
        toolbar = findViewById(R.id.toolBar);
//        setSupportActionBar(toolbar);

        lvCourses = (ListView) findViewById(R.id.lv_courses);

        courses = PrefConfig.readListFromPref(Courses.this);
        if(courses == null){
            courses = new ArrayList<Course>(); }

        courseAdapter = new CourseAdapter(this,courses);
        lvCourses.setAdapter(courseAdapter);

        lvCourses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                new AlertDialog.Builder(Courses.this)
                        .setTitle("Are You Sure That You Want To Remove This Course?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                courses.remove(position);
                                courseAdapter.notifyDataSetChanged();
                                PrefConfig.writeListInPref(Courses.this, courses);
                            }
                        })
                        .setNegativeButton("No", null).show();
                return true;
            }
        });

        FAB = (FloatingActionButton) findViewById(R.id.FAB);
        FAB.setColorFilter(R.color.white);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialogue();
            }
        });

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ivWeekly = findViewById(R.id.iv_weeklyCal);
        ivWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Courses.this, WeeklyCalendarView.class);
                PrefConfig.writeListInPref(Courses.this, courses);
                startActivity(intent);
            }
        });

    }

    private void OpenDialogue(){
        AddCourse addCourse = new AddCourse();
        addCourse.show(getSupportFragmentManager(), "Add Course");

    }

    @Override
    public void sendInput(Course c) throws ParseException {
        boolean checkCourses = true;
        for (int i = 0; i < courses.size(); i++) {
            if (c.CourseName.equals(courses.get(i).CourseName)) {
                Log.e("loop", "loop runs");

                Toast.makeText(this, "Course Already Added", Toast.LENGTH_SHORT);
                checkCourses = false;
            } else {
                if(c.Days.equals(courses.get(i).Days)) {
                    if (c.StartTime.equals(courses.get(i).StartTime)) {
                        Toast.makeText(this, "Time Slot Clash", Toast.LENGTH_SHORT);
                        checkCourses = false;
                    }
                }
            }
        }

        if(checkCourses == true) {
            courses.add(c);
            courseAdapter.notifyDataSetChanged();
            Log.d("Dialoge", "Added new course to list");
            PrefConfig.writeListInPref(Courses.this, courses);
        }
    }

    private void createNotificationChannel(){

    }
}