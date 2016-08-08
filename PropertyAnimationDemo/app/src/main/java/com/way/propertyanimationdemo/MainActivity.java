package com.way.propertyanimationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * //设置操作属性的一系列值float
     * ofFloat(float... values)
     * <p>
     * ofInt(int... values)
     * <p>
     * ofObject(TypeEvaluator evaluator,Object... values)
     * <p>
     * //用于实现组合动画等
     * ofPropertyValuesHolder(PropertyValuesHolder... values)
     * <p>
     * setFrameDelay(long frameDelay)
     * <p>
     * ValueAnimator setDuration(long duration)
     * <p>
     * //获取ValueAnimator在运动时，当前运动点的值
     * Object getAnimatedValue();
     * <p>
     * //开始动画
     * void start()
     * <p>
     * //设置循环次数,设置为INFINITE表示无限循环
     * void setRepeatCount(int value)
     * <p>
     * //设置循环模式 value取值有RESTART，REVERSE
     * void setRepeatMode(int value)
     * <p>
     * // 取消动画
     * void cancel()
     **/

    private final static String TAG = MainActivity.class.getName();

    Button btnValueAnimator, btnObjectAnimatorRotation, btnObjectAnimatorAlpha,
            btnObjectAnimatorSet;
    ImageView ivPhoto, ivDot;

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

        btnValueAnimator = (Button) findViewById(R.id.btnValueAnimator);
        btnObjectAnimatorRotation = (Button) findViewById(R.id.btnObjectAnimatorRotation);
        btnObjectAnimatorAlpha = (Button) findViewById(R.id.btnObjectAnimatorAlpha);
        btnObjectAnimatorSet = (Button) findViewById(R.id.btnObjectAnimatorSet);
        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        ivDot = (ImageView) findViewById(R.id.ivDot);

        btnValueAnimator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
                    valueAnimator.setDuration(3000);

                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            float value = (Float) animation.getAnimatedValue();
                            ivPhoto.setTranslationX(value);
                        }
                    });
                    valueAnimator.start();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onCreate debug, Value Animator", e);
                }

            }
        });

        btnObjectAnimatorRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivPhoto, "rotation", 0, 360);
                    objectAnimator.setDuration(3000);
                    objectAnimator.start();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onCreate debug, Object Animator Rotation", e);
                }

            }
        });

        btnObjectAnimatorAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(ivPhoto, "alpha", 0, 1);
                    objectAnimator.setDuration(3000);
                    objectAnimator.start();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onCreate debug, Object Animator Alpha", e);
                }

            }
        });

        btnObjectAnimatorSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(ivPhoto, "scaleY", 0, 1);
                    ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(ivPhoto, "scaleX", 0, 1);
                    ObjectAnimator rotationXAnimator = ObjectAnimator.ofFloat(ivPhoto, "rotation", 0, 360);
                    ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(ivPhoto, "alpha", 0, 1);
                    AnimatorSet animationSet = new AnimatorSet();
                    animationSet.playTogether(scaleXAnimator, scaleYAnimator, alphaAnimator, rotationXAnimator);
                    animationSet.setDuration(3000);
                    animationSet.start();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onCreate debug, Object Animator Set", e);
                }

            }
        });
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
        if (id == R.id.action_xml) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
