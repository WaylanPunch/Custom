package com.way.clipboardmanagerdemo;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    private ClipboardManager mClipboardManager;
    private TextView tvHelloWorld;
    private Button btnClipboardCopy, btnClipboardPaste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        tvHelloWorld = (TextView) findViewById(R.id.tvHelloWorld);
        btnClipboardCopy = (Button) findViewById(R.id.btnClipboardCopy);
        btnClipboardPaste = (Button) findViewById(R.id.btnClipboardPaste);

        btnClipboardCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData mClipData;
                String text = "hello world";
                mClipData = ClipData.newPlainText("test", text);
                mClipboardManager.setPrimaryClip(mClipData);
            }
        });


        btnClipboardPaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData clipData = mClipboardManager.getPrimaryClip();
                ClipData.Item item = clipData.getItemAt(0);
                String pasteData = item.getText().toString();
                tvHelloWorld.setText(pasteData);

                // If the string contains data, then the paste operation is done
                if (pasteData != null) {
                    return;

                    // The clipboard does not contain text. If it contains a URI, attempts to get data from it
                } else {
                    Uri pasteUri = item.getUri();

                    // If the URI contains something, try to get text from it
                    if (pasteUri != null) {

                        // calls a routine to resolve the URI and get data from it. This routine is not
                        // presented here.
                        //pasteData = resolveUri(Uri);
                        return;
                    } else {

                        // Something is wrong. The MIME type was plain text, but the clipboard does not contain either
                        // text or a Uri. Report an error.
                        Log.i(TAG, "Clipboard contains an invalid data type");
                        return;
                    }
                }
            }
        });

        mClipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                Log.i(TAG, "onPrimaryClipChanged: ");
            }
        });
    }


    public void fakeClipboard() {
        // 添加一个假的Intent，模拟用户最新加入的剪贴板内容
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.hjwordgames", "com.hjwordgames.Splash"));
        intent.setAction("android.intent.action.VIEW");
        ClipData setClipData;
        setClipData = ClipData.newIntent("intent", intent);
        mClipboardManager.setPrimaryClip(setClipData);

        // 呵呵哒 App以为获取的是自己需要的Intent，结果却被狸猫换太子
        ClipData clipData = mClipboardManager.getPrimaryClip();
        ClipData.Item myItem;
        myItem = clipData.getItemAt(0);
        String clipDataString = myItem.coerceToText(this.getApplicationContext()).toString();
        try {
            Intent myIntent = Intent.parseUri(clipDataString, 0);
            startActivity(myIntent);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
