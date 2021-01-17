package com.example.aucschedd;

import android.graphics.Color;

public class Course {
    String CourseName;
    String Days;
    String TimeSlot;
    int Credits;
    int CRN;
    int color;

    public Course(String courseName, String days, String timeSlot, int credits, int CRN, int color) {
        this.CourseName = courseName;
        this.Days = days;
        this.TimeSlot = timeSlot;
        this.Credits = credits;
        this.CRN = CRN;
        this.color = color;
    }
}
