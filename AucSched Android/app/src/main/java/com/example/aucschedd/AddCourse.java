package com.example.aucschedd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import java.text.ParseException;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddCourse extends AppCompatDialogFragment {
    EditText etCourseName;
    EditText etCRN;
    EditText etDays;
    EditText etTime1;
    EditText etTime2;
    EditText etCredits;
    Button Colour;
    Button Add;
    ImageView Cancel;
    int defaultColour;


    public interface OnAdd{
        void sendInput(Course c) throws ParseException;
    }

    public OnAdd onAdd;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.add_course, null);
        builder.setView(view);
        Cancel = (ImageView) view.findViewById(R.id.iv_cancel);
        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        defaultColour = ContextCompat.getColor(getActivity(),R.color.yellow);
        Colour = (Button) view.findViewById(R.id.colorPick);
        Colour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColourPicker(view);
            }
        });

        Add = (Button) view.findViewById(R.id.b_add);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = etCourseName.getText().toString();
                String CRN = etCRN.getText().toString();
                String Days = etDays.getText().toString();
                String startTime = etTime1.getText().toString();
                String endTime = etTime2.getText().toString();
                String Credits = etCredits.getText().toString();
                String Col = Integer.toString(defaultColour);
                Course c = new Course(courseName, Days, startTime, endTime, Credits, CRN, Col);
                try {
                    onAdd.sendInput(c);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                getDialog().dismiss();
            }
        });

        etCourseName = view.findViewById(R.id.et_courseName);
        etCRN = view.findViewById(R.id.et_CRN);
        etDays = view.findViewById(R.id.et_Days);
        etTime1 = view.findViewById(R.id.et_time1);
        etTime2 = view.findViewById(R.id.et_time2);
        etCredits = view.findViewById(R.id.et_credits);
        Colour = view.findViewById(R.id.colorPick);

        return builder.create();
    }

    public void openColourPicker(View view){
        AmbilWarnaDialog colourPicker = new AmbilWarnaDialog(getActivity(), defaultColour, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColour = color;
                Colour.setBackgroundColor(defaultColour);
            }
        });
        colourPicker.show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onAdd = (OnAdd)context;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public boolean checkDigits(String CRN){
        boolean flag = true;
        for(int i = 0;i < CRN.length(); i++){
            if(!Character.isDigit(CRN.charAt(i))){
                return false;
            }
        }
        return flag;
    }
}
