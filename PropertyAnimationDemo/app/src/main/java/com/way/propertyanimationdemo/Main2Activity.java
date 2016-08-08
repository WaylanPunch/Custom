package com.way.propertyanimationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private final static String TAG = Main2Activity.class.getName();

    Button btnValueAnimator, btnObjectAnimatorRotation, btnObjectAnimatorAlpha,
            btnObjectAnimatorSet;
    ImageView ivPhoto, ivDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate debug");

        btnValueAnimator = (Button) findViewById(R.id.btnValueAnimator);
        btnObjectAnimatorRotation = (Button) findViewById(R.id.btnObjectAnimatorRotation);
        btnObjectAnimatorAlpha = (Button) findViewById(R.id.btnObjectAnimatorAlpha);
        btnObjectAnimatorSet = (Button) findViewById(R.id.btnObjectAnimatorSet);
        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        ivDot = (ImageView) findViewById(R.id.ivDot);

        btnValueAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onCreate debug, Rotate Animator");
                try {
                    Animator animator = AnimatorInflater.loadAnimator(Main2Activity.this,
                            R.animator.roation);
                    animator.setTarget(ivPhoto);
                    animator.start();
                } catch (Exception e) {
                    Toast.makeText(Main2Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onCreate debug, Rotate Animator", e);
                }
            }
        });

        btnObjectAnimatorRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onCreate debug, Animator Set");
                try {
                    Animator animator = AnimatorInflater.loadAnimator(Main2Activity.this,
                            R.animator.animator_set);
                    animator.setTarget(ivPhoto);
                    animator.start();
                } catch (Exception e) {
                    Toast.makeText(Main2Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onCreate debug, Animator Set", e);
                }
            }
        });
    }
}
