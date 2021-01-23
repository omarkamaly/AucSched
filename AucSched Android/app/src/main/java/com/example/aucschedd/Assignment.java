package com.example.aucschedd;

public class Assignment {

    private String CourseName;
    private int DueDay;
    private int DueMonth;
    private int DueYear;
    private String Details;
    private boolean expandable;

    public Assignment(String courseName, int dueDay, int dueMonth, int dueYear, String details, boolean expandable) {
        this.CourseName = courseName;
        this.DueDay = dueDay;
        this.DueMonth = dueMonth;
        this.DueYear = dueYear;
        this.Details = details;
        this.expandable = expandable;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getDueDay() {
        return DueDay;
    }

    public void setDueDay(int dueDay) {
        DueDay = dueDay;
    }

    public int getDueMonth() {
        return DueMonth;
    }

    public void setDueMonth(int dueMonth) {
        DueMonth = dueMonth;
    }

    public int getDueYear() {
        return DueYear;
    }

    public void setDueYear(int dueYear) {
        DueYear = dueYear;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}
