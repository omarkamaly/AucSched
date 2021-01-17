package com.example.aucschedd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddCourse extends AppCompatDialogFragment {
    EditText etCourseName;
    EditText etCRN;
    EditText etDays;
    EditText etTimeSlot;
    EditText etCredits;
    Button Colour;

    //AddCourseListener listener;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_course, null);

        builder.setView(view).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                String courseName = etCourseName.getText().toString();
//                String CRN = etCRN.getText().toString();
//                String Days = etDays.getText().toString();
//                String timeSlot = etTimeSlot.getText().toString();
//                String Credits = etCredits.getText().toString();
//                //add here whatever ill need for colour
//                listener.ApplyTexts(courseName, CRN, Days, timeSlot, Credits);
            }
        });

        etCourseName = view.findViewById(R.id.et_courseName);
        etCRN = view.findViewById(R.id.et_CRN);
        etDays = view.findViewById(R.id.et_Days);
        etTimeSlot = view.findViewById(R.id.et_timeSlot);
        etCredits = view.findViewById(R.id.et_credits);
        Colour = view.findViewById(R.id.colorPick);

        return builder.create();
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//
//        try {
//            listener = (AddCourseListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString() + "must implement example AddCourseListener");
//        }
//    }
//
//    public interface AddCourseListener{
//        void ApplyTexts(String courseName, String CRN, String Days, String timeSlot, String Credits);
//    }
}
