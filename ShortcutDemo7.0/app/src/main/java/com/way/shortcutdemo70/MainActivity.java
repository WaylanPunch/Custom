package com.way.shortcutdemo70;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        Button btnAdd = (Button) findViewById(R.id.btn_add_shortcut);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
                ShortcutInfo shortcut = new ShortcutInfo.Builder(MainActivity.this, "shortcutId3")
                        .setShortLabel("Weibo")
                        .setLongLabel("Find Me On Weibo")
                        .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.ic_messagescenter_at))
                        .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("http://weibo.com/waylanpunch")))
                        .build();
                try {
                    shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnRemove = (Button) findViewById(R.id.btn_remove_shortcut);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
                List<ShortcutInfo> shortcutInfoList = shortcutManager.getDynamicShortcuts();//可以做个list管理App Shortcuts，这里略
                List<String> list = new ArrayList<>();
                list.add("shortcutId3");
                try {
                    shortcutManager.removeDynamicShortcuts(list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button btnDisable = (Button) findViewById(R.id.btn_disable_shortcut);
        btnDisable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
                List<String> list = new ArrayList<>();
                list.add("shortcutId3");
                try {
                    shortcutManager.disableShortcuts(list);
                } catch (Exception e) {
                    e.printStackTrace();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
