package com.way.screenshotdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import android.widget.Toast;

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

    //这种方法状态栏是空白，显示不了状态栏的信息
    private void saveCurrentImage(String fullFilePath) {
        //获取当前屏幕的大小
        int width = getWindow().getDecorView().getRootView().getWidth();
        int height = getWindow().getDecorView().getRootView().getHeight();
        //生成相同大小的图片
        Bitmap temBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //找到当前页面的跟布局
        View view = getWindow().getDecorView().getRootView();
        //设置缓存
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        //从缓存中获取当前屏幕的图片
        temBitmap = view.getDrawingCache();

        //输出到sd卡
        //if (FileIOUtil.getExistStorage()) {
        //FileIOUtil.GetInstance().onFolderAnalysis(FileIOUtil.GetInstance().getFilePathAndName());
        //File file = new File(FileIOUtil.GetInstance().getFilePathAndName());
        File file = new File(fullFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream foStream = new FileOutputStream(file);
            temBitmap.compress(Bitmap.CompressFormat.PNG, 100, foStream);
            foStream.flush();
            foStream.close();
        } catch (Exception e) {
            Log.i("Show", e.toString());
        }
        //}
    }


    //保存自定义view的截图
    private void saveCustomViewBitmap(CustomView mCodeView, String fullFilePath) {
        //获取自定义view图片的大小
        Bitmap temBitmap = Bitmap.createBitmap(mCodeView.getWidth(), mCodeView.getHeight(), Bitmap.Config.ARGB_8888);
        //使用Canvas，调用自定义view控件的onDraw方法，绘制图片
        Canvas canvas = new Canvas(temBitmap);
        //mCodeView.onDraw(canvas);
        mCodeView.draw(canvas);

        //输出到sd卡
        //if (FileIOUtil.getExistStorage()) {
        //FileIOUtil.GetInstance().onFolderAnalysis(FileIOUtil.GetInstance().getFilePathAndName());
        //File file = new File(FileIOUtil.GetInstance().getFilePathAndName());
        File file = new File(fullFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream foStream = new FileOutputStream(file);
            temBitmap.compress(Bitmap.CompressFormat.PNG, 100, foStream);
            foStream.flush();
            foStream.close();
            Toast.makeText(MainActivity.this, "截屏文件已保存至" + fullFilePath, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Log.i("Show", e.toString());
        }
        //}
    }
}
