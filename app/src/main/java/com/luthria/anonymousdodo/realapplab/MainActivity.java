package com.luthria.anonymousdodo.realapplab;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

public static ArrayList<Class> classes = new ArrayList<Class>();
    Typeface typeface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Howard County GPA Calculator");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager am = getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Font.ttf"));

        init();

        TextView tV = (TextView) findViewById(R.id.textView7);
        tV.setText("Hold each button to see what it does");
        tV.setTypeface(typeface);



        FloatingActionButton delete = (FloatingActionButton) findViewById(R.id.deleteClass);
        delete.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    return shToast("Release To Delete A Class");

                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    onDelete(v);

                }

                return false;
            }
        });


        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.addClass);
        add.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    return shToast("Release To Add A Class");

                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    onAddClick(v);

                }

                return false;
            }
        });

        FloatingActionButton get = (FloatingActionButton) findViewById(R.id.calcGPA);
        get.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                  return shToast("Release for GPA");
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    getGPA(v);

                }

                return false;
            }
        });

    }

    public boolean shToast(String text){
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
        return true;
    }

    public void onAddClick(View v){
        startActivity(new Intent(MainActivity.this, AddClass.class));
    }
    public void getGPA(View v){
        startActivity(new Intent(MainActivity.this, GetGPA.class));

    }
    public void onDelete(View v){
        startActivity(new Intent(MainActivity.this, DeleteClass.class));

    }
    public void init() {
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setTypeface(typeface);
        tv0.setText(" Class ");
        tv0.setTextColor(Color.parseColor("#3507C8"));
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Weight ");
        tv1.setTypeface(typeface);

        tv1.setTextColor(Color.parseColor("#3507C8"));
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Grade ");
        tv2.setTextColor(Color.parseColor("#3507C8"));
        tv2.setTypeface(typeface);

        tbrow0.addView(tv2);
        stk.addView(tbrow0);
        for (int i = 0; i < classes.size(); i++) {
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setTypeface(typeface);

            t1v.setText(classes.get(i).getName() + "    ");
            t1v.setTextColor(Color.parseColor("#3507C8"));
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText(classes.get(i).getType() +"    ");
            t2v.setTextColor(Color.parseColor("#3507C8"));
            t2v.setTypeface(typeface);

            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText(classes.get(i).getLetter() +"    ");
            t3v.setTextColor(Color.parseColor("#3507C8"));
            t3v.setTypeface(typeface);

            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            stk.addView(tbrow);
        }

    }

}
