package com.example.aucschedd;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Advising3 extends AppCompatActivity {
    String interest;
    ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advising3);
        String g1 = getIntent().getStringExtra("g1");
        String g2 = getIntent().getStringExtra("g2");
        String g3 = getIntent().getStringExtra("g3");
        String g4 = getIntent().getStringExtra("g4");
        String g5 = getIntent().getStringExtra("g5");
        String g6 = getIntent().getStringExtra("g6");
        String g7 = getIntent().getStringExtra("g7");
        String g8 = getIntent().getStringExtra("g8");
        String g9 = getIntent().getStringExtra("g9");
        String g10 = getIntent().getStringExtra("g10");
        String g11 = getIntent().getStringExtra("g11");
        TextView t1 = (TextView) findViewById(R.id.textView);
        TextView t2 = (TextView) findViewById(R.id.textView12);
        TextView t3 = (TextView) findViewById(R.id.textView13);
        TextView t4 = (TextView) findViewById(R.id.textView14);
        TextView t5 = (TextView) findViewById(R.id.textView15);
        TextView t6 = (TextView) findViewById(R.id.textView16);
        TextView t7 = (TextView) findViewById(R.id.textView17);
        TextView t8 = (TextView) findViewById(R.id.textView18);
        TextView t9 = (TextView) findViewById(R.id.textView19);
        TextView t10 = (TextView) findViewById(R.id.textView20);
        TextView t11 = (TextView) findViewById(R.id.textView21);
        TextView t12 = (TextView) findViewById(R.id.textView23);
        t1.setText(g1);
        t2.setText(g2);
        t3.setText(g3);
        t4.setText(g4);
        t5.setText(g5);
        t6.setText(g6);
        t7.setText(g7);
        t8.setText(g8);
        t9.setText(g9);
        t10.setText(g10);
        t11.setText(g11);
        if (t1.getText().toString().equals("")) {
            t1.setVisibility(View.GONE);
        }
        if (t2.getText().toString().equals("")) {
            t2.setVisibility(View.GONE);
        }
        if (t3.getText().toString().equals("")) {
            t3.setVisibility(View.GONE);
        }
        if (t4.getText().toString().equals("")) {
            t4.setVisibility(View.GONE);
        }
        if (t5.getText().toString().equals("")) {
            t5.setVisibility(View.GONE);
        }
        if (t6.getText().toString().equals("")) {
            t6.setVisibility(View.GONE);
        }
        if (t7.getText().toString().equals("")) {
            t7.setVisibility(View.GONE);
        }
        if (t8.getText().toString().equals("")) {
            t8.setVisibility(View.GONE);
        }
        if (t9.getText().toString().equals("")) {
            t9.setVisibility(View.GONE);
        }
        if (t10.getText().toString().equals("")) {
            t10.setVisibility(View.GONE);
        }
        if (t11.getText().toString().equals("")) {
            t11.setVisibility(View.GONE);
        }


    }
}
