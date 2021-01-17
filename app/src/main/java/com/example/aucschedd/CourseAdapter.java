package com.example.aucschedd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CourseAdapter extends ArrayAdapter<Course> {
    public CourseAdapter(Context context, ArrayList<Course> courses) {
        super(context, 0, courses);
    }

    @Override
    public Course getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Course course = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_list_line, parent, false);
        }

        TextView tvCourseName = (TextView)  convertView.findViewById(R.id.tv_courseName);
        TextView tvCRN = (TextView)  convertView.findViewById(R.id.tv_CRN);
        TextView tvDays = (TextView)  convertView.findViewById(R.id.tv_days);
        TextView tvTimeSlot = (TextView)  convertView.findViewById(R.id.tv_timeSlot);
        TextView tvCredits = (TextView)  convertView.findViewById(R.id.tv_credits);
        ImageView ivColour = (ImageView) convertView.findViewById(R.id.iv_colour);

        tvCourseName.setText(course.CourseName);
        tvCRN.setText(course.CRN);
        tvCredits.setText(course.Credits);
        tvDays.setText(course.Days);
        tvTimeSlot.setText(course.TimeSlot);
        ivColour.setColorFilter(course.color);

        return convertView;

    }
}
