package com.way.once;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

/**
 * 64k方法数限制的解决方案
 * https://developer.android.com/studio/build/multidex.html
 */

public class OnceApp extends MultiDexApplication {

    private Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;


    }

    public static void setTheme(){
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        //调用recreate()使设置生效
        //reCreate();
    }
}
