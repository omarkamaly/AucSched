package com.example.aucschedd;

public class CoursesAd {
    int ID;
    String CourseName;
    boolean taken;
    int CourseCredits;
    String Major;

    public CoursesAd(int ID, String courseName, boolean taken, int courseCredits, String major) {
        this.ID = ID;
        this.CourseName = courseName;
        this.taken = taken;
        this.CourseCredits = courseCredits;
        this.Major = major;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public int getCourseCredits() {
        return CourseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        CourseCredits = courseCredits;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }
}
