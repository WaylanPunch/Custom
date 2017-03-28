package com.waylanpunch.interviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.waylanpunch.interviewdemo.widget.scrolltextview.ScrollTextViewLayout;

public class ScrollTextViewActivity extends AppCompatActivity {

    ScrollTextViewLayout scrollTextViewLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_text_view);

        scrollTextViewLayout = (ScrollTextViewLayout)findViewById(R.id.scrollTextView);
        scrollTextViewLayout.setTextArray(new String[]{"asdasdasd","dfsdfsdfsd","vfvdfvdfvd"});
    }
}
