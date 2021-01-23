package com.example.aucschedd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.allyants.notifyme.NotifyMe;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AssignmentManager extends AppCompatActivity implements AddAssignment.OnAddA
{

    RecyclerView recyclerView;
    ArrayList<Assignment> assignmentList;
    FloatingActionButton FAB;
    AssignmentAdapter assignmentAdapter;
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_manager);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ArrayList<Course> courses;
        courses = PrefConfig.readListFromPref(this);
        ArrayList<String> courseNames = new ArrayList<String>();
        for(int i = 0; i < courses.size(); i++){
            courseNames.add(courses.get(i).CourseName);
        }

        recyclerView = findViewById(R.id.rv_list);

        assignmentList = PrefConfig.readAssignmentFromPref(AssignmentManager.this);
        if(assignmentList == null){
            assignmentList = new ArrayList<Assignment>();
        }

        assignmentAdapter = new AssignmentAdapter(assignmentList);
        recyclerView.setAdapter(assignmentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);

        FAB = findViewById(R.id.FAB);
        FAB.setColorFilter(R.color.white);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAssignment addAssignment = new AddAssignment();
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("Course Names", courseNames);
                addAssignment.setArguments(bundle);
                addAssignment.show(getSupportFragmentManager(), "Add Assignment");            }
        });


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                assignmentList.remove(viewHolder.getAdapterPosition());
                assignmentAdapter.notifyDataSetChanged();
                PrefConfig.writeAssignmentsInPref(AssignmentManager.this, assignmentList);
                NotifyMe.cancel(getApplicationContext(), Integer.toString(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void sendInput(Assignment a) throws ParseException {
        assignmentList.add(a);
        assignmentAdapter.notifyDataSetChanged();
        Log.d("Dialoge", "Added new course to list");
        PrefConfig.writeAssignmentsInPref(AssignmentManager.this, assignmentList);

        Calendar calendar = Calendar.getInstance();

        int sec = calendar.get(Calendar.SECOND);
        calendar.set(Calendar.YEAR, a.getDueYear());
        calendar.set(Calendar.MONTH, a.getDueMonth());
        calendar.set(Calendar.DAY_OF_MONTH, a.getDueDay() - 1);
        calendar.set(Calendar.SECOND, sec + 5);

        Log.e("YOOOO", Integer.toString(a.getDueYear()));
        Log.e("YOOOOO", Integer.toString(a.getDueMonth()));
        Log.e("YOOOOOO", Integer.toString(a.getDueDay()));

        NotifyMe notifyMe = new NotifyMe.Builder(getApplicationContext())
                .title(a.getCourseName() + " Assignment Due Tomorrow")
                .time(calendar)
                .key(Integer.toString(assignmentList.indexOf(a)))
                .addAction(new Intent(), "Dismiss", true, false)
                .small_icon(R.drawable.iconn)
                .large_icon(R.drawable.iconn)
                .build();
    }

}