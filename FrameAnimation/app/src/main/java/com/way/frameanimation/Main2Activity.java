package com.way.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private final static String TAG = Main2Activity.class.getName();

    AnimationDrawable anim;

    Button btnStartAnimation, btnStopAnimation;
    ImageView ivLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate debug");
        setContentView(R.layout.activity_main2);

        btnStartAnimation = (Button) findViewById(R.id.btnStartAnimation);
        btnStopAnimation = (Button) findViewById(R.id.btnStopAnimation);
        ivLoading = (ImageView) findViewById(R.id.ivLoading);


        anim = new AnimationDrawable();
        for (int i = 1; i <= 12; i++) {
            //根据资源名称和目录获取R.java中对应的资源ID
            int id;
            if (i < 10) {
                id = getResources().getIdentifier("loading_0" + i, "drawable", getPackageName());
            } else {
                id = getResources().getIdentifier("loading_" + i, "drawable", getPackageName());
            }
            //根据资源ID获取到 Drawable对象
            Drawable drawable = getResources().getDrawable(id);
            //将此帧添加到AnimationDrawable中
            anim.addFrame(drawable, 100);
        }
        //设置循环播放
        anim.setOneShot(false);
        //设置图片的背景为我们的动画
        ivLoading.setBackgroundDrawable(anim);


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


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(TAG, "onWindowFocusChanged debug");
        anim.start();
    }
}
