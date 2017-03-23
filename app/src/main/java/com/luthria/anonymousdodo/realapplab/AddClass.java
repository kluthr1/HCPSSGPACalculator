package com.luthria.anonymousdodo.realapplab;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static android.R.attr.duration;

public class AddClass extends AppCompatActivity {
    private static Spinner grade;
    private static Spinner weight;
    private static EditText text;
    public Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Add Classes");

        AssetManager am = getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Font2.ttf"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclass);
        String[] grades = new String[6];
        grades[0] = "A";
        grades[1] = "B";
        grades[2] = "C";
        grades[3] = "D";
        grades[4] = "E";
        grades[5] = "F";

        grade = (Spinner) findViewById(R.id.Grade);
        ArrayAdapter<String> gradeAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, grades);
        grade.setAdapter(gradeAdapter);
        String[] diff = {"Regular", "Honors", "AP/GT"};
        ArrayAdapter<String> weightAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, diff);
        weight = (Spinner) findViewById(R.id.Weight);
        weight.setAdapter(weightAdapter);
        text = (EditText) findViewById(R.id.Name);
        text.setTypeface(typeface);

        FloatingActionButton addClass = (FloatingActionButton) findViewById(R.id.confirm);

        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setTypeface(typeface);
        t2.setText("Enter Your Class Information");
        TextView t3 = (TextView) findViewById(R.id.textView3);
        t3.setTypeface(typeface);
        t3.setText("Enter Your Final Grade");
        TextView t4 = (TextView) findViewById(R.id.textView4);
        t4.setTypeface(typeface);
        t4.setText("Enter The Type of Class");
        TextView t5 = (TextView) findViewById(R.id.textView5);
        t5.setTypeface(typeface);
        t5.setText("Enter The Name of The Class");


        FloatingActionButton get = (FloatingActionButton) findViewById(R.id.confirm);
        get.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Release to Return to the Home Screen", Toast.LENGTH_SHORT);
                    toast.show();
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    onConfirm(v);

                }

                return false;
            }
        });

    }

    public void confirmClass(View v) {
        String val = grade.getSelectedItem().toString();
        int gradeVal = 0;
        if (val.equals("A")) {
            gradeVal = 4;
        }
        if (val.equals("B")) {
            gradeVal = 3;
        }
        if (val.equals("C")) {
            gradeVal = 2;
        }
        if (val.equals("D")) {
            gradeVal = 1;
        }

        double weightVal = 0;
        String we = weight.getSelectedItem().toString();
        if (we.equals("Honors")) {
            weightVal = .5;
        }
        if (we.equals("AP/GT")) {
            weightVal = 1;
        }


        MainActivity.classes.add(new Class(text.getText().toString(), gradeVal, weightVal, grade.getSelectedItem().toString(), weight.getSelectedItem().toString()));


    }

    public void onConfirm(View v) {
        startActivity(new Intent(AddClass.this, MainActivity.class));


    }
}
