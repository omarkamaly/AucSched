package com.example.aucschedd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AdvisedCourses extends AppCompatActivity {

    Button button;

    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11;
    final List<String> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advised_courses);

        String input1 = getIntent().getStringExtra("get1");
        String input2 = getIntent().getStringExtra("get2");
        CheckBox cb2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox)findViewById(R.id.checkBox5);
        CheckBox cb6 = (CheckBox)findViewById(R.id.checkBox6);
        CheckBox cb7 = (CheckBox)findViewById(R.id.checkBox7);
        CheckBox cb8 = (CheckBox)findViewById(R.id.checkBox8);
        CheckBox cb9 = (CheckBox)findViewById(R.id.checkBox9);
        CheckBox cb20 = (CheckBox)findViewById(R.id.checkBox20);
        CheckBox cb21 = (CheckBox)findViewById(R.id.checkBox21);
        button= (Button)findViewById(R.id.button6);

        //means student declared
        if ("Computer Engineering".equals(input1) || "Computer Engineering".equals(input2))
        {
            cb2.setText("CS 106");
            cb3.setText("CS 110");
            cb4.setText("PHY 1");
            cb5.setText("CALC 1");
            cb6.setText("CALC 2");
            cb7.setText("Intro to Eng");
            cb8.setText("Drawing");
            cb9.setText("Rhet");
            cb20.setText("Core");
            cb21.setText("Chemistry");

            button.setOnClickListener( new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(cb2.isChecked()==false)
                    {
                        g1=cb2.getText().toString();
                    }if(cb3.isChecked()==false)
                    {
                        g2=cb3.getText().toString();
                    }if(cb4.isChecked()==false)
                    {
                        g3=cb4.getText().toString();
                    } if(cb5.isChecked()==false)
                    {
                        g4=cb5.getText().toString();
                    }if(cb6.isChecked()==false)
                    {
                        g5=cb6.getText().toString();
                    } if(cb7.isChecked()==false)
                    {
                        g6=cb7.getText().toString();
                    } if(cb8.isChecked()==false)
                    {
                        g7=cb8.getText().toString();
                    } if(cb9.isChecked()==false)
                    {
                        g8=cb9.getText().toString();
                    } if(cb20.isChecked()==false)
                    {
                        g10=cb20.getText().toString();
                    } if(cb21.isChecked()==false)
                    {
                        g11=cb21.getText().toString();
                    }
                    Intent intent = new Intent(AdvisedCourses.this,Advising3.class);
                    intent.putExtra("g1",g1);
                    intent.putExtra("g2",g2);
                    intent.putExtra("g3",g3);
                    intent.putExtra("g4",g4);
                    intent.putExtra("g5",g5);
                    intent.putExtra("g6",g6);
                    intent.putExtra("g7",g7);
                    intent.putExtra("g8",g8);
                    intent.putExtra("g9",g9);
                    intent.putExtra("g10",g10);
                    intent.putExtra("g11",g11);
                    startActivity(intent);

                }
            });

        }else if ("Computer Science".equals(input1) || "Computer Science".equals(input2))
        {
            cb2.setText("CS 106");
            cb3.setText("CS 110");
            cb4.setText("PHY 1");
            cb5.setText("CALC 1");
            cb6.setText("CALC 2");
            cb7.setText("Scientific Thinking ");
            cb8.setText("Philosophical thinking");
            cb9.setText("Rhet");
            cb20.setText("Core");
            cb21.setText("Lalt");
            button.setOnClickListener( new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(cb2.isChecked()==false)
                    {
                        g1=cb2.getText().toString();
                    }if(cb3.isChecked()==false)
                    {
                        g2=cb3.getText().toString();
                    }if(cb4.isChecked()==false)
                    {
                        g3=cb4.getText().toString();
                    } if(cb5.isChecked()==false)
                    {
                        g4=cb5.getText().toString();
                    }if(cb6.isChecked()==false)
                    {
                        g5=cb6.getText().toString();
                    } if(cb7.isChecked()==false)
                    {
                        g6=cb7.getText().toString();
                    } if(cb8.isChecked()==false)
                    {
                        g7=cb8.getText().toString();
                    } if(cb9.isChecked()==false)
                    {
                        g8=cb9.getText().toString();
                    } if(cb20.isChecked()==false)
                    {
                        g10=cb20.getText().toString();
                    } if(cb21.isChecked()==false)
                    {
                        g11=cb21.getText().toString();
                    }
                    Intent intent = new Intent(AdvisedCourses.this,Advising3.class);
                    intent.putExtra("g1",g1);
                    intent.putExtra("g2",g2);
                    intent.putExtra("g3",g3);
                    intent.putExtra("g4",g4);
                    intent.putExtra("g5",g5);
                    intent.putExtra("g6",g6);
                    intent.putExtra("g7",g7);
                    intent.putExtra("g8",g8);
                    intent.putExtra("g9",g9);
                    intent.putExtra("g10",g10);
                    intent.putExtra("g11",g11);
                    startActivity(intent);


                }
            });
        }

    }
}
