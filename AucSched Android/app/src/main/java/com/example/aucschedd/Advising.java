package com.example.aucschedd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Advising extends AppCompatActivity implements View.OnClickListener {
    private Spinner semesternumber;
    public String get1 = "";
    public String get2 = "false";
    private Spinner major;
    private Button button2;
    private List<String> list;
    public String test;
    private Spinner intending;
    private Spinner plan;
    Button mOrder;
    String[] list1;
    String[] list2;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advising);

        Context context = getApplicationContext();
        semesternumber = findViewById(R.id.semesternumber);
        major = findViewById(R.id.major);
        intending = findViewById(R.id.intending);
        plan = findViewById(R.id.plan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesternumber.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Major, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        major.setAdapter(adapter1);
//        list1=getResources().getStringArray(R.array.CE);
//        checkedItems= new boolean[list1.length];
        mOrder = (Button) findViewById(R.id.button);
        mOrder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Advising.this, AdvisedCourses.class);
                intent.putExtra("get1", get1);
                intent.putExtra("get2", get2);
                startActivity(intent);
            }
        });
//        list2=getResources().getStringArray(R.array.Cs);
//        checkedItems= new boolean[list2.length];

        semesternumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String temp = "";
                String msg = "";

                {
                    temp = (String) parent.getItemAtPosition(position);
                    if ("one".equals(temp)) {
                        intending.setVisibility(LinearLayout.VISIBLE);
                        major.setVisibility(LinearLayout.VISIBLE);
                        plan.setVisibility(LinearLayout.VISIBLE);
                    } else if ("two".equals(temp)) {
                        intending.setVisibility(LinearLayout.VISIBLE);
                        major.setVisibility(LinearLayout.VISIBLE);
                        plan.setVisibility(LinearLayout.VISIBLE);
                    } else {
                        msg = "This advising is only for freshmen, please choose semester one or two";
                        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                        intending.setVisibility(LinearLayout.GONE);
                        major.setVisibility(LinearLayout.GONE);
                        plan.setVisibility(LinearLayout.GONE);
                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        major.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp = "";
                String msg = "";
                temp = (String) parent.getItemAtPosition(position);
                get1 = temp;
                if ("choose your major".equals(temp)) {
                    msg = "Please select a valid major";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                } else if ("Computer Engineering".equals(temp)) {
                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(context, R.array.plan, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    plan.setAdapter(adapter3);
                    intending.setVisibility(LinearLayout.GONE);

                } else if ("Computer Science".equals(temp)) {

                    ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(context, R.array.plan, android.R.layout.simple_spinner_item);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    plan.setAdapter(adapter3);
                    intending.setVisibility(LinearLayout.GONE);

                } else if ("Undecalred".equals(temp)) {

                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context, R.array.intending, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    intending.setAdapter(adapter2);
                    msg = "Pick from the intending majors, the major you want to declare";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                    intending.setVisibility(View.VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        intending.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp = "";
                String msg = "";
                temp = (String) parent.getItemAtPosition(position);
//                get2=temp;
                if ("choose your intending major".equals(temp)) {
                    msg = "Please choose your intending major";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                } else if ("Computer Engineering".equals(temp)) {
                    get2 = temp;
                } else if ("Computer Science".equals(temp)) {
                    get2 = temp;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        plan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp = "";
                String msg = "";
                temp = (String) parent.getItemAtPosition(position);
                if ("choose your plan".equals(temp)) {
                    msg = "Please choose your plan year";
                    Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });
    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.next) {
            Intent intent = new Intent(this, AdvisedCourses.class);
            this.startActivity(intent);
        }
    }
}



//semesternumber.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String semester2 =  semesternumber.getSelectedItem(). toString();
//        if (semester2.equals("Semester")){
//            semester1.setText("you choose"+semesternumber);
//    }
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
//
//});
