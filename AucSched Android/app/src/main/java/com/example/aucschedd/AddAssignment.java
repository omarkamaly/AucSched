package com.example.aucschedd;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.arch.core.executor.TaskExecutor;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

public class AddAssignment extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener{
    Spinner spinner;
    Button due;
    EditText details;
    TextView tvShowDue;
    private String strDate;
    String selectedCourse;
    String Details;
    int newday, newmonth, newyear;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCourse = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public interface OnAddA{
        void sendInput(Assignment a) throws ParseException;
    }

    public OnAddA onAddA;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_assignment, null);

        tvShowDue = view.findViewById(R.id.tv_showdue);

        spinner = view.findViewById(R.id.spinner);
        Bundle bundle = getArguments();
        ArrayList<String> courseNames  = new ArrayList<String>();
        courseNames= bundle.getStringArrayList("Course Names");

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
                        newday = dayOfMonth;
                        newmonth = month;
                        newyear = year;
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
                        Assignment a = new Assignment(selectedCourse, newday, newmonth, newyear, Details, false);
                        try {
                            onAddA.sendInput(a);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

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
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String due = dayOfMonth + "/" + month + "/" + year;
        tvShowDue.setText(due);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            onAddA = (  OnAddA)context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
