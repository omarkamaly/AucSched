package com.example.aucschedd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddToCalendar extends AppCompatDialogFragment {
    EditText Title;
    EditText Location;
    EditText Description;
    Button addBtn;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.activity_add_to_calendar, null);

        builder.setView(view).setTitle("Event Form")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                })
                .setPositiveButton("Add Event", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(!Title.getText().toString().isEmpty() && !Location.getText().toString().isEmpty() && !Description.getText().toString().isEmpty()){

                            Intent intent = new Intent(Intent.ACTION_INSERT);
                            intent.setData(CalendarContract.Events.CONTENT_URI);
                            intent.putExtra(CalendarContract.Events.TITLE, Title.getText().toString());
                            intent.putExtra(CalendarContract.Events.EVENT_LOCATION, Location.getText().toString());
                            intent.putExtra(CalendarContract.Events.DESCRIPTION, Description.getText().toString());
                            intent.putExtra(CalendarContract.Events.ALL_DAY, true);
                            //check to see if there is calendar app that can do this
//                    if(intent.resolveActivity(getPackageManager()) != null)  {
//                        startActivity(intent);
//                    }else {
//                        startActivity(intent);
//                        //Toast.makeText(MainActivity.this, "There is no Calendar app", Toast.LENGTH_SHORT).show();
//                    }
                            startActivity(intent);
                        }else {
                            Toast.makeText(getActivity(), "Please fill all fields", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

        Title = view.findViewById(R.id.Title);
        Location = view.findViewById(R.id.Location);
        Description = view.findViewById(R.id.Description);

        return builder.create();
    }
}
