package com.example.aucschedd;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CourseList#newInstance} factory method to
 * create an instance of this fragment.
 */
//public class CourseList extends Fragment implements AddCourse.AddCourseListener {
public class CourseList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ListView lvCourses;
    FloatingActionButton FAB;

    ArrayList<Course> courses;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CourseList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CourseList.
     */
    // TODO: Rename and change types and number of parameters
    public static CourseList newInstance(String param1, String param2) {
        CourseList fragment = new CourseList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);

        lvCourses = (ListView) view.findViewById(R.id.lv_courses);

        courses = new ArrayList<Course>();

        FAB = (FloatingActionButton) view.findViewById(R.id.FAB);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenDialogue();
            }
        });

        CourseAdapter courseAdapter = new CourseAdapter(getActivity(), courses);
        lvCourses.setAdapter(courseAdapter);

        return view;
    }

    private void OpenDialogue(){
        AddCourse addCourse = new AddCourse();
        addCourse.show(getChildFragmentManager(), "Add Course");
    }

//    @Override
//    public void ApplyTexts(String courseName, String CRN, String Days, String timeSlot, String Credits) {
//        int credits = Integer.parseInt(Credits);
//        int crn = Integer.parseInt(CRN);
//        int colour = 0;
//
//        Course c = new Course(courseName, Days, timeSlot, credits, crn, colour);
//
//        courses.add(c);
//    }
}