package com.example.aucschedd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Advising extends AppCompatActivity implements View.OnClickListener {
    Spinner semesternumber;
    private Spinner major;
    private Spinner intending;
    private Spinner plan;
    Button mOrder;
    Button Next;
    TextView mItemSelected;
    String[] listItems;
    String[] list2;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advising);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        Resources resources = context.getResources();
        //View v = findViewById(R.id.next);
        //v.setOnClickListener((View.OnClickListener) this);
        Next = (Button) findViewById(R.id.next);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Advising.this, AdvisedCourses.class);
                startActivity(i);
            }
        });

        semesternumber = (Spinner) findViewById(R.id.semesternumber);
        major = findViewById(R.id.major);
        intending = findViewById(R.id.intending);
        plan = findViewById(R.id.plan);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Semester, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        semesternumber.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.Major, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        major.setAdapter(adapter1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.intending, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        intending.setAdapter(adapter2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.plan, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        plan.setAdapter(adapter3);
//      list2=getResources().getStringArray(R.array.Cs);
//      checkedItems2= new boolean[list2.length];

        mOrder = findViewById(R.id.button);
        mItemSelected=findViewById(R.id.textview);
        listItems = resources.getStringArray(R.array.CE);
        checkedItems = new boolean[listItems.length];
        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Advising.this);
                mBuilder.setTitle(R.string.dialog_title);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            if (!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        } else if (mUserItems.contains(position)) {
                            mUserItems.remove(position);

                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i!=mUserItems.size()-1)
                            {
                                item= item+", ";
                            }
                        }
                        mItemSelected.setText(item);
                    }
                });
                mBuilder.setNegativeButton(R.string.dimiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i< checkedItems.length; i++)
                        {
                            checkedItems[i]=false;
                            mUserItems.clear();
                            mItemSelected.setText("");
                        }
                    }
                });
                AlertDialog mDialog= mBuilder.create();
                mDialog.show();
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
