package com.example.aucschedd;

import android.graphics.Color;

public class Course {
    String CourseName;
    String Days;
    String StartTime;
    String EndTime;
    String Credits;
    String CRN;
    String Colour;

    public Course(String courseName, String days, String StartTime, String EndTime, String credits, String CRN, String Colour) {
        this.CourseName = courseName;
        this.Days = days;
        this.StartTime = StartTime;
        this.EndTime = EndTime;
        this.Credits = credits;
        this.CRN = CRN;
        this.Colour = Colour;
    }
}
