package com.luthria.anonymousdodo.realapplab;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DeleteClass extends AppCompatActivity {
    Typeface typeface;

    private Spinner dels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Delete Class");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_class);

        String[] delVals = new String[MainActivity.classes.size()];
        for(int i= 0; i< MainActivity.classes.size(); i++){
            delVals[i] =  (i+1) +"";
        }
         dels = (Spinner) findViewById(R.id.spinner2);
        dels.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, delVals));

        AssetManager am = getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "Font3.ttf"));




        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);

        TextView tv4 = new TextView(this);
        tv4.setText(" Number ");
        tv4.setTextColor(Color.parseColor("#3507C8"));
        tv4.setTypeface(typeface);
        tbrow0.addView(tv4);

        TextView tv0 = new TextView(this);
        tv0.setText(" Class ");
        tv0.setTextColor(Color.parseColor("#3507C8"));
        tv0.setTypeface(typeface);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText(" Weight ");
        tv1.setTextColor(Color.parseColor("#3507C8"));
        tv1.setTypeface(typeface);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText(" Grade ");
        tv2.setTextColor(Color.parseColor("#3507C8"));
        tv2.setTypeface(typeface);

        tbrow0.addView(tv2);
        stk.addView(tbrow0);
        for (int i = 0; i < MainActivity.classes.size(); i++) {
            TableRow tbrow = new TableRow(this);
            TextView t0v = new TextView(this);
            t0v.setText(i+1+"");
            t0v.setTextColor(Color.parseColor("#3507C8"));
            t0v.setTypeface(typeface);

            t0v.setGravity(Gravity.CENTER);
            tbrow.addView(t0v);
            TextView t1v = new TextView(this);
            t1v.setText(MainActivity.classes.get(i).getName());
            t1v.setTextColor(Color.parseColor("#3507C8"));

            t1v.setTypeface(typeface);

            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText(MainActivity.classes.get(i).getType() +"");
            t2v.setTextColor(Color.parseColor("#3507C8"));
            t2v.setTypeface(typeface);

            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText(MainActivity.classes.get(i).getLetter() +"");
            t3v.setTextColor(Color.parseColor("#3507C8"));
            t3v.setTypeface(typeface);

            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            stk.addView(tbrow);
        }
        FloatingActionButton get = (FloatingActionButton) findViewById(R.id.toHome);
        get.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Release to Return to the Home Screen", Toast.LENGTH_SHORT);
                    toast.show();
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    toHome(v);

                }

                return false;
            }
        });
        FloatingActionButton delete = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        delete.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Release to Delete the Selected Class", Toast.LENGTH_SHORT);
                    toast.show();
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    delete(v);

                }

                return false;
            }
        });

        TextView t6 =(TextView) findViewById(R.id.textView6);
        t6.setTypeface(typeface);
        t6.setText("Enter the Number of the Class You Wish to Delete");

    }
    public void toHome(View v){
        startActivity(new Intent(DeleteClass.this, MainActivity.class));
    }
    public void delete(View v){
        MainActivity.classes.remove(Integer.parseInt(dels.getSelectedItem().toString()) -1 );
       toHome(v);
    }


}
