package com.luthria.anonymousdodo.realapplab;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class GetGPA extends AppCompatActivity {
private Typeface typeface;
    private ShareActionProvider mShareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AssetManager am = getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Font4.ttf"));

        setTitle("What is Your GPA");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_gpa);

        TextView reg = (TextView) findViewById(R.id.reg);
        reg.setTypeface(typeface);
        reg.setText("UnWeighted: " +  getRegGPA());
        TextView weight = (TextView) findViewById(R.id.weighted);
        weight.setTypeface(typeface);
        weight.setText("Weighted: " +  getWeighted());
        TextView mess = (TextView) findViewById(R.id.textView);
        mess.setTypeface(typeface);
        mess.setText("Congratulations Your GPA is ");




        FloatingActionButton get = (FloatingActionButton) findViewById(R.id.back);
        get.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Release to Return to the Home Screen", Toast.LENGTH_SHORT);
                    toast.show();
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    back(v);

                }

                return false;
            }
        });

    }
    public double getRegGPA(){
        ArrayList<Class> classes =MainActivity.classes;
        int x = 0;
        for(int i = 0; i<classes.size(); i++){
            x+=classes.get(i).getGrade();

        }
        return  x/ (double) classes.size();
    }
    public double getWeighted(){
        ArrayList<Class> classes =MainActivity.classes;
        double x = 0;
        for(int i = 0; i<classes.size(); i++){
            x+=classes.get(i).getWeighted();

        }
        return  x/ (double) classes.size();
    }

    public void back(View v){
        startActivity(new Intent(GetGPA.this, MainActivity.class));
    }
    public void share(View v) {
        // Inflate menu resource file.

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey My GPA is " + getRegGPA() + " Unweighted and " + getWeighted() + " Weighted! Whats your GPA";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My GPA");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

        //then set the sharingIntent
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }



}
