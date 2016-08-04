package com.way.tweenanimationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    Button btnRotate, btnRotateFillAfter, btnRotateFillBefore, btnRotatePivot,
            btnRotatePivotPercent, btnRotatePivotPercentP, btnRotateRepeatMode,
            btnAlpha, btnTranslate, btnScale, btnSet, btnTranslateAnticipateInterpolator,
            btnTranslateBounceInterpolator, btnTranslateAnticipateInterpolatorCustom,
            btnTranslateAnticipateOvershootInterpolator, btnTranslateOvershootInterpolator;
    ImageView ivPhoto, ivDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

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
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate);
//                ivPhoto.startAnimation(animation);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(3000);
                ivPhoto.startAnimation(rotateAnimation);
            }
        });

        btnRotateFillAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate_fillafter);
//                ivPhoto.startAnimation(animation);
            }
        });

        btnRotateFillBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate_fillbefore);
//                ivPhoto.startAnimation(animation);
            }
        });

        btnRotatePivot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate_pivot);
//                ivPhoto.startAnimation(animation);
            }
        });

        btnRotatePivotPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate_pivot_percent);
//                ivPhoto.startAnimation(animation);
            }
        });

        btnRotatePivotPercentP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate_pivot_percent_p);
//                ivPhoto.startAnimation(animation);
            }
        });

        btnRotateRepeatMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_rotate_repeat);
//                ivPhoto.startAnimation(animation);
            }
        });

        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_alpha);
//                ivPhoto.startAnimation(animation);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(3000);
                alphaAnimation.setRepeatCount(2);
                alphaAnimation.setFillAfter(true);
                ivPhoto.setAnimation(alphaAnimation);
            }
        });

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_translate);
//                ivDot.startAnimation(animation);
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                        Animation.ABSOLUTE, 200, Animation.ABSOLUTE, 300);
                translateAnimation.setDuration(5000);
                ivPhoto.setAnimation(translateAnimation);
            }
        });

        btnScale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_scale);
//                ivPhoto.startAnimation(animation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(5000);
                ivPhoto.startAnimation(scaleAnimation);
            }
        });

        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_set);
//                ivPhoto.startAnimation(animation);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setDuration(3000);

                RotateAnimation rotateAnimation = new RotateAnimation(0, 720,
                        Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(3000);

                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 85,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
                translateAnimation.setDuration(1000);
                translateAnimation.setStartOffset(3000);

                AlphaAnimation alphaAnimation = new AlphaAnimation(1f, 0f);
                alphaAnimation.setDuration(1000);
                alphaAnimation.setStartOffset(4000);

                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(scaleAnimation);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(alphaAnimation);

                ivPhoto.startAnimation(animationSet);
            }
        });

        btnTranslateAnticipateInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_translate_anticipate_interpolator);
//                ivDot.startAnimation(animation);
            }
        });

        btnTranslateBounceInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_translate_bounce_interpolator);
//                ivDot.startAnimation(animation);
                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 250);
                translateAnimation.setInterpolator(new BounceInterpolator());
                translateAnimation.setFillAfter(true);
                translateAnimation.setDuration(2000);

                ivDot.startAnimation(translateAnimation);
            }
        });

        btnTranslateAnticipateInterpolatorCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_translate_anticipate_interpolator_custom);
//                ivDot.startAnimation(animation);
            }
        });

        btnTranslateAnticipateOvershootInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_translate_anticipate_overshoot_interpolator);
//                ivDot.startAnimation(animation);
            }
        });

        btnTranslateOvershootInterpolator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animation = AnimationUtils.loadAnimation(Main2Activity.this, R.anim.photo_translate_overshoot_interpolator);
//                ivDot.startAnimation(animation);

            }
        });
    }
}
