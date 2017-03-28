package com.waylanpunch.interviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnScrollTextView, btnViewPager, btnViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnScrollTextView = (Button) findViewById(R.id.btnScrollTextView);
        btnViewPager = (Button) findViewById(R.id.btnViewPager);
        btnViewPager2 = (Button) findViewById(R.id.btnViewPager2);

        btnScrollTextView.setOnClickListener(this);
        btnViewPager.setOnClickListener(this);
        btnViewPager2.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnScrollTextView:
                Intent intent1 = new Intent(MainActivity.this, ScrollTextViewActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnViewPager:
                Intent intent2 = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnViewPager2:
                Intent intent3 = new Intent(MainActivity.this, ViewPager2Activity.class);
                startActivity(intent3);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
