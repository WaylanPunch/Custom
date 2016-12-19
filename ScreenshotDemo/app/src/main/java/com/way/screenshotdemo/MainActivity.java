package com.way.screenshotdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    Button button;
    Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcontext = this;
        button = (Button) findViewById(R.id.my_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
                String fname = "/sdcard/DCIM/" + sdf.format(new Date()) + ".png";
                View view = v.getRootView();
                view.setDrawingCacheEnabled(true);
                view.buildDrawingCache();
                Bitmap bitmap = view.getDrawingCache();
                if (bitmap != null) {
                    Log.i(TAG, "bitmap got!");
                    try {
                        FileOutputStream out = new FileOutputStream(fname);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                        Log.i(TAG, "file " + fname + " output done.");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.i(TAG, "bitmap is NULL!");
                }
            }
        });
    }

    /*
    public boolean takeScreenShot(String imagePath){
        if(imagePath.equals("" )){
            imagePath = Environment.getExternalStorageDirectory()+ File. separator+"Screenshot.png" ;
        }

        Bitmap mScreenBitmap;
        WindowManager mWindowManager;
        DisplayMetrics mDisplayMetrics;
        Display mDisplay;

        mWindowManager = (WindowManager) mcontext.getSystemService(Context.WINDOW_SERVICE);
        mDisplay = mWindowManager.getDefaultDisplay();
        mDisplayMetrics = new DisplayMetrics();
        mDisplay.getRealMetrics(mDisplayMetrics);

        float[] dims = {mDisplayMetrics.widthPixels , mDisplayMetrics.heightPixels };
        mScreenBitmap = Surface.screenshot((int) dims[0], ( int) dims[1]);
        if (mScreenBitmap == null) {
            return false ;
        }
        try {
            FileOutputStream out = new FileOutputStream(imagePath);
            mScreenBitmap.compress(Bitmap.CompressFormat. PNG, 100, out);
        } catch (Exception e) {
            return false ;
        }
        return true ;
    }
    */
}
