package com.way.tweenanimationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnRotate, btnRotateFillAfter, btnRotateFillBefore, btnRotatePivot,
            btnRotatePivotPercent, btnRotatePivotPercentP, btnRotateRepeatMode,
            btnAlpha, btnTranslate, btnScale, btnSet, btnTranslateAnticipateInterpolator,
            btnTranslateBounceInterpolator, btnTranslateAnticipateInterpolatorCustom,
            btnTranslateAnticipateOvershootInterpolator, btnTranslateOvershootInterpolator;
    ImageView ivPhoto, ivDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRotate = (Button) findViewById(R.id.btnRotate);
        btnRotateFillAfter = (Button) findViewById(R.id.btnRotateFillAfter);
        btnRotateFillBefore = (Button) findViewById(R.id.btnRotateFillBefore);
        btnRotatePivot = (Button) findViewById(R.id.btnRotatePivot);
        btnRotatePivotPercent = (Button) findViewById(R.id.btnRotatePivotPercent);
        btnRotatePivotPercentP = (Button) findViewById(R.id.btnRotatePivotPercentP);
        btnRotateRepeatMode = (Button) findViewById(R.id.btnRotateRepeatMode);
        btnAlpha = (Button) findViewById(R.id.btnAlpha);
        btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnScale = (Button) findViewById(R.id.btnScale);
        btnSet = (Button) findViewById(R.id.btnSet);
        btnTranslateAnticipateInterpolator = (Button) findViewById(R.id.btnTranslateAnticipateInterpolator);
        btnTranslateBounceInterpolator = (Button) findViewById(R.id.btnTranslateBounceInterpolator);
        btnTranslateAnticipateInterpolatorCustom = (Button) findViewById(R.id.btnTranslateAnticipateInterpolatorCustom);
        btnTranslateAnticipateOvershootInterpolator = (Button) findViewById(R.id.btnTranslateAnticipateOvershootInterpolator);
        btnTranslateOvershootInterpolator = (Button) findViewById(R.id.btnTranslateOvershootInterpolator);

        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        ivDot = (ImageView) findViewById(R.id.ivDot);

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate);
                ivPhoto.startAnimation(animation);
            }
        });

        btnRotateFillAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate_fillafter);
                ivPhoto.startAnimation(animation);
            }
        });

        btnRotateFillBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate_fillbefore);
                ivPhoto.startAnimation(animation);
            }
        });

        btnRotatePivot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate_pivot);
                ivPhoto.startAnimation(animation);
            }
        });

        btnRotatePivotPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate_pivot_percent);
                ivPhoto.startAnimation(animation);
            }
        });

        btnRotatePivotPercentP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate_pivot_percent_p);
                ivPhoto.startAnimation(animation);
            }
        });

        btnRotateRepeatMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_rotate_repeat);
                ivPhoto.startAnimation(animation);
            }
        });

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_alpha);
                ivPhoto.startAnimation(animation);
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_translate);
                ivDot.startAnimation(animation);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_scale);
                ivPhoto.startAnimation(animation);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_set);
                ivPhoto.startAnimation(animation);
            }
        });

        btnTranslateAnticipateInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_translate_anticipate_interpolator);
                ivDot.startAnimation(animation);
            }
        });

        btnTranslateBounceInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_translate_bounce_interpolator);
                ivDot.startAnimation(animation);
            }
        });

        btnTranslateAnticipateInterpolatorCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_translate_anticipate_interpolator_custom);
                ivDot.startAnimation(animation);
            }
        });

        btnTranslateAnticipateOvershootInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_translate_anticipate_overshoot_interpolator);
                ivDot.startAnimation(animation);
            }
        });

        btnTranslateOvershootInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.photo_translate_overshoot_interpolator);
                ivDot.startAnimation(animation);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_code) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
