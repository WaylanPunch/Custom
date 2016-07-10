package com.way.scoreview;

import android.app.Application;
import android.content.Context;

/**
 * Created by pc on 2016/7/11.
 */
public class MyApp extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
