package com.way.screenshotdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by pc on 2016/12/19.
 */

public class CustomView extends RelativeLayout {
    public CustomView(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
