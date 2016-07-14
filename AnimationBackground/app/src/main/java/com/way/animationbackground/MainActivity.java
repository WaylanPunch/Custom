package com.way.animationbackground;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout container = (ConstraintLayout) findViewById(R.id.activity_main);
        container.addView(new MyAnimationView(this));
    }

    public class MyAnimationView extends View {

//        private static final int COLOR_START = 0xffFF8080;
//        private static final int COLOR_END = 0xff8080FF;

//        private final int COLOR_START = ColorUtil.getResourcesColor(R.color.colorAccent);
//        private final int COLOR_END = ColorUtil.getResourcesColor(R.color.colorPrimary);

        private final int COLOR_START = Color.parseColor("#FFFFFF");
        private final int COLOR_END = Color.parseColor("#3F51B5");

        public MyAnimationView(Context context) {
            super(context);

            // Animate background color
            // Note that setting the background color will automatically invalidate the
            // view, so that the animated color, and the bouncing balls, get redisplayed on
            // every frame of the animation.
            ValueAnimator colorAnim = ObjectAnimator.ofInt(this, "backgroundColor", COLOR_START, COLOR_END);
            colorAnim.setDuration(3000);
            colorAnim.setEvaluator(new ArgbEvaluator());
            colorAnim.setRepeatCount(ValueAnimator.INFINITE);
            colorAnim.setRepeatMode(ValueAnimator.REVERSE);
            colorAnim.start();
        }
    }
}
