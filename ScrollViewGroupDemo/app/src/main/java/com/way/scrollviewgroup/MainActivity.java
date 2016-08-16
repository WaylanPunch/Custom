package com.way.scrollviewgroup;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton fab;
    //private RelativeLayout content_main;
    private ScrollViewGroup svg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //step4：初始化我们自定义的scrollview并填充数据数据
        //content_main = (RelativeLayout) findViewById(R.id.content_main);
        svg = (ScrollViewGroup) findViewById(R.id.svg);
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        int mScreenHeight = wm.getDefaultDisplay().getHeight();

        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, mScreenHeight);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, mScreenHeight);
        ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, mScreenHeight);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, mScreenHeight);

        ImageView imageView = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);
        ImageView imageView4 = new ImageView(this);

        imageView.setLayoutParams(layoutParams);
        imageView2.setLayoutParams(layoutParams2);
        imageView3.setLayoutParams(layoutParams3);
        imageView4.setLayoutParams(layoutParams4);

        imageView.setBackgroundResource(R.drawable.img1);
        imageView2.setBackgroundResource(R.drawable.img2);
        imageView3.setBackgroundResource(R.drawable.img3);
        imageView4.setBackgroundResource(R.drawable.img4);

        svg.addView(imageView);
        svg.addView(imageView2);
        svg.addView(imageView3);
        svg.addView(imageView4);
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
