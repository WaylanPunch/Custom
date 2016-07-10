package com.way.scoreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTip;
    LinearLayout llScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTip = (TextView)findViewById(R.id.tv_tip);
        llScoreView = (LinearLayout)findViewById(R.id.ll_scoreview);

        llScoreView.addView(new ScoreView(this,80));
    }
}
