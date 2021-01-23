package com.example.aucschedd;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.allyants.notifyme.NotifyMe;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class AddAssHome extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button due;
    EditText details;
    TextView tvShowDue;
    private String strDate;
    String selectedCourse;
    String Details;
    DatePickerDialog.OnDateSetListener setListener;
    int newday, newmonth, newyear;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        newyear = year;
        newmonth = month;
        newday =  dayOfMonth;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_assignment, null);

        tvShowDue = view.findViewById(R.id.tv_showdue);

        spinner = view.findViewById(R.id.spinner);

        ArrayList<Course>  courses = PrefConfig.readListFromPref(getActivity());
        if(courses == null){
            Toast.makeText(getActivity(), "There are no courses scheduled in course list", Toast.LENGTH_LONG);
            return builder.create();
        }

        ArrayList<Assignment> assignments = PrefConfig.readAssignmentFromPref(getActivity());
        ArrayList<String> courseNames  = new ArrayList<String>();
        for(int i = 0; i < courses.size(); i++){
            courseNames.add(courses.get(i).CourseName);
        }

        spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, courseNames);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        details = view.findViewById(R.id.et_details);

        due = (Button) view.findViewById(R.id.b_datepicker);
        due.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                setListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String due = dayOfMonth + "/" + month + "/" + year;
                        tvShowDue.setText(due);
                        newyear = year;
                        newmonth = month;
                        newday =  dayOfMonth;
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });


        builder.setView(view)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Details = details.getText().toString();
                        strDate = tvShowDue.getText().toString();
                        Assignment a = new Assignment(selectedCourse, newday, newmonth, newyear, Details, false);
                        assignments.add(a);
                        Calendar calendar = Calendar.getInstance();

                        int sec = calendar.get(Calendar.SECOND);
                        calendar.set(Calendar.YEAR, a.getDueYear());
                        calendar.set(Calendar.MONTH, a.getDueMonth());
                        calendar.set(Calendar.DAY_OF_MONTH, a.getDueDay() - 1);
                        calendar.set(Calendar.SECOND, sec + 5);

                        Log.e("YEEEE", Integer.toString(a.getDueYear()));
                        Log.e("YEEEEE", Integer.toString(a.getDueMonth()));
                        Log.e("YEEEEEEE", Integer.toString(a.getDueDay()));

                        NotifyMe notifyMe = new NotifyMe.Builder(getActivity())
                                .title(a.getCourseName() + " Assignment Due Tomorrow")
                                .time(calendar)
                                .key(Integer.toString(assignments.indexOf(a)))
                                .addAction(new Intent(), "Dismiss", true, false)
                                .small_icon(R.drawable.iconn)
                                .large_icon(R.drawable.iconn)
                                .build();
                        PrefConfig.writeAssignmentsInPref(getActivity(), assignments);


                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                })
                .setTitle("Add Assignment Details");

        return builder.create();
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCourse = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
