package com.example.aucschedd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class WeeklyCalendarView extends AppCompatActivity {

    TextView U1;
    TextView U2;
    TextView U3;
    TextView U4;
    TextView U5;
    TextView U6;
    TextView U7;

    TextView M1;
    TextView M2;
    TextView M3;
    TextView M4;
    TextView M5;
    TextView M6;
    TextView M7;

    TextView T1;
    TextView T2;
    TextView T3;

    TextView W1;
    TextView W2;
    TextView W3;
    TextView W4;
    TextView W5;
    TextView W6;
    TextView W7;

    TextView R1;
    TextView R2;
    TextView R3;
    TextView R4;
    TextView R5;
    TextView R6;
    TextView R7;

    ImageView ivBack;

    ArrayList<Course> courses = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_calendar_view);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        courses = PrefConfig.readListFromPref(WeeklyCalendarView.this);
        if(courses == null){
            Log.e("empty", "array list empty");
            courses = new ArrayList<Course>();
        }
        else{
            System.out.println(courses.get(0).CourseName);
        }

        connectScheduleBoxes();


        for(int i = 0; i < courses.size(); i++){
            setUpWeeklyCalendar(courses.get(i));
        }
    }

    private void connectScheduleBoxes(){
        U1 = findViewById(R.id.tv_U1);
        U2 = findViewById(R.id.tv_U2);
        U3 = findViewById(R.id.tv_U3);
        U4 = findViewById(R.id.tv_U4);
        U5 = findViewById(R.id.tv_U5);
        U6 = findViewById(R.id.tv_U6);
        U7 = findViewById(R.id.tv_U7);

        M1 = findViewById(R.id.tv_M1);
        M2 = findViewById(R.id.tv_M2);
        M3 = findViewById(R.id.tv_M3);
        M4 = findViewById(R.id.tv_M4);
        M5 = findViewById(R.id.tv_M5);
        M6 = findViewById(R.id.tv_M6);
        M7 = findViewById(R.id.tv_M7);

        T1 = findViewById(R.id.tv_T1);
        T2 = findViewById(R.id.tv_T2);
        T3 = findViewById(R.id.tv_T3);

        W1 = findViewById(R.id.tv_W1);
        W2 = findViewById(R.id.tv_W2);
        W3 = findViewById(R.id.tv_W3);
        W4 = findViewById(R.id.tv_W4);
        W5 = findViewById(R.id.tv_W5);
        W6 = findViewById(R.id.tv_W6);
        W7 = findViewById(R.id.tv_W7);

        R1 = findViewById(R.id.tv_R1);
        R2 = findViewById(R.id.tv_R2);
        R3 = findViewById(R.id.tv_R3);
        R4 = findViewById(R.id.tv_R4);
        R5 = findViewById(R.id.tv_R5);
        R6 = findViewById(R.id.tv_R6);
        R7 = findViewById(R.id.tv_R7);
    }

    private void setUpWeeklyCalendar(Course c){
        if(c.Days.contains("UW")){
            if(c.StartTime.contains("8:30")){
                U1.setText(c.CourseName); W1.setText(c.CourseName);
                U1.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); W1.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                U1.setTextColor(getResources().getColor(R.color.white)); W1.setTextColor(getResources().getColor(R.color.white));

            }

            else if(c.StartTime.contains("10:00")){
                U2.setText(c.CourseName); W2.setText(c.CourseName);
                U2.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); W2.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                U2.setTextColor(getResources().getColor(R.color.white)); W2.setTextColor(getResources().getColor(R.color.white));
            }

            else if (c.StartTime.contains("11:30")) {
                U3.setText(c.CourseName); W3.setText(c.CourseName);
                U3.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); W3.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                U3.setTextColor(getResources().getColor(R.color.white)); W3.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("2:00")){
                U5.setText(c.CourseName); W5.setText(c.CourseName);
                U5.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); W5.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                U5.setTextColor(getResources().getColor(R.color.white)); W5.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("3:30")){
                U6.setText(c.CourseName); W6.setText(c.CourseName);
                U6.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); W6.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                U6.setTextColor(getResources().getColor(R.color.white)); W6.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("5:00")){
                U7.setText(c.CourseName); W7.setText(c.CourseName);
                U7.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); W7.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                U7.setTextColor(getResources().getColor(R.color.white)); W7.setTextColor(getResources().getColor(R.color.white));
            }
        }

        else if(c.Days.contains("MR")){
            if(c.StartTime.contains("8:30")){
                M1.setText(c.CourseName); R1.setText(c.CourseName);
                M1.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); R1.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                M1.setTextColor(getResources().getColor(R.color.white)); R1.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("10:00")){
                M2.setText(c.CourseName); R2.setText(c.CourseName);
                M2.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); R2.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                M2.setTextColor(getResources().getColor(R.color.white)); R2.setTextColor(getResources().getColor(R.color.white));
            }

            else if (c.StartTime.contains("11:30")) {
                M3.setText(c.CourseName); R3.setText(c.CourseName);
                M3.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); R3.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                M3.setTextColor(getResources().getColor(R.color.white)); R3.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("2:00")){
                M5.setText(c.CourseName); R5.setText(c.CourseName);
                M5.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); R5.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                M5.setTextColor(getResources().getColor(R.color.white)); R5.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("3:30")){
                M6.setText(c.CourseName); R6.setText(c.CourseName);
                M6.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); R6.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                M6.setTextColor(getResources().getColor(R.color.white)); R6.setTextColor(getResources().getColor(R.color.white));
            }

            else if(c.StartTime.contains("5:00")){
                M7.setText(c.CourseName); R7.setText(c.CourseName);
                M7.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP); R7.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                M7.setTextColor(getResources().getColor(R.color.white)); R7.setTextColor(getResources().getColor(R.color.white));
            }
        }

        else if(c.Days.contains("T")){
            if(c.StartTime.contains("8:30")){
                T1.setText(c.CourseName);
                T1.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                T1.setTextColor(getResources().getColor(R.color.white));
            }
            else if(c.StartTime.contains("11:30")){
                T2.setText(c.CourseName);
                T2.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                T2.setTextColor(getResources().getColor(R.color.white));
            }
            else if(c.StartTime.contains("2:30")){
                T3.setText(c.CourseName);
                T3.getBackground().setColorFilter(Integer.parseInt(c.Colour), PorterDuff.Mode.SRC_ATOP);
                T3.setTextColor(getResources().getColor(R.color.white));
            }
        }
    }
}