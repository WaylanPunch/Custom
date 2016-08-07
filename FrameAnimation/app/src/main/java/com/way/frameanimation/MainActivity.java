package com.way.frameanimation;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    AnimationDrawable anim;

    Button btnStartAnimation, btnStopAnimation;
    ImageView ivLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate debug");

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

        btnStartAnimation = (Button) findViewById(R.id.btnStartAnimation);
        btnStopAnimation = (Button) findViewById(R.id.btnStopAnimation);
        ivLoading = (ImageView) findViewById(R.id.ivLoading);

//        ivLoading.setBackgroundResource(R.drawable.anim_loading);
//        anim = (AnimationDrawable) ivLoading.getBackground();
//        //anim.start();
//        ivLoading.post( new Runnable() {
//            @Override
//            public void run() {
//                anim.start();
//            }
//        });

        btnStartAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim.start();
            }
        });
        btnStopAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anim.stop();
            }
        });
    }

    /**
     * 然后运行在Android 2.3.3的模拟器上发现次动画只停留在第一帧，
     * 但是当我们点击启动动画按钮时动画会正常的播放(因为此时windows窗口已经完全初始化)，
     * 然后我们代码不变将此工程运行在高版本上，我是运行在Android 4.1.2的模拟器上的，
     * 发现动画是正常播放的(并没有停留在第一帧)。但是为了兼容性更好，更安全我们最好将启动动画的代码写在onWindowFocusChanged方法中
     **/
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(TAG, "onWindowFocusChanged debug");
        //将背景设置为动画
        ivLoading.setBackgroundResource(R.drawable.anim_loading);
        anim = (AnimationDrawable) ivLoading.getBackground();
        //启动动画
        anim.start();
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
        if (id == R.id.action_code) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
