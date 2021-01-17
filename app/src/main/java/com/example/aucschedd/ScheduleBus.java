package com.example.aucschedd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ScheduleBus extends AppCompatActivity {
    //for toast
    public static String msg="";
    public String temp="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_bus);
        Context context = getApplicationContext();
        TextView textView = (TextView) findViewById(R.id.textView);
        Spinner dropdown = findViewById(R.id.spinner1);
        String[] bus_time;
        ArrayAdapter<String> adapter;
        bus_time = getResources().getStringArray(R.array.bus_time);
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                bus_time);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button clickButton = findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Set Bus Time".equals(temp)){
                    msg="Please select correct time to set alarm for bus";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                } else if ("10".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,9);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("11".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,10);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("12".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,11);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("1".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,12);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("2".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,1);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("3".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,2);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("4".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,3);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }else if ("5".equals(temp)){
                    msg="Alarm has been set 15 mins before bus time";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(AlarmClock.ACTION_SET_ALARM);
                    intent.putExtra(AlarmClock.EXTRA_HOUR,4);
                    intent.putExtra(AlarmClock.EXTRA_MINUTES,45);
                    startActivity(intent);
                }
            }
        });
    }
}
