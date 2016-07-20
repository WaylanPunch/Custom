package com.way.once.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.way.once.NotifyEvent;
import com.way.once.R;
import com.way.once.utils.ToolbarUtils;

import de.greenrobot.event.EventBus;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

public class MainActivity extends BaseActivity {
    private final static String TAG = MainActivity.class.getName();

    private PulsatorLayout pulsator;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewID() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        pulsator = (PulsatorLayout) findViewById(R.id.pulsator);

    }

    @Override
    public void initToolbar(){
        ToolbarUtils.initMainToolbar(toolbar, this);
    }

    @Override
    protected void initViewData() {
        pulsator.start();

    }



    /*
    protected void toggleTranslucent(boolean isTranslucent) {
        if (isTranslucent) {
            StatusBarCompat.translucentStatusBar(this);
            //StatusBarCompat.translucentStatusBar(this);
        } else {
            StatusBarCompat.setStatusBarColor(this, StatusBarCompat.COLOR_DEFAULT_WHITE);
            //StatusBarCompat.setStatusBarColor(this);
        }
    }
    */

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
            Intent intent = new Intent(MainActivity.this,SettingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void onEventMainThread(NotifyEvent event) {
        Log.d(TAG, "onEventMainThread debug, NotifyEvent Type = " + event.getType());
        switch (event.getType()) {
            case NotifyEvent.REFRESH_LIST:
//                view.startRefresh();
//                onRefresh();
                break;
            case NotifyEvent.CREATE_NOTE:
//                if (event.getData() instanceof SNote) {
//                    SNote note = (SNote) event.getData();
//                    view.addNote(note);
//                    view.scrollRecyclerViewToTop();
//                    pushNote(note);
//                }
                break;
            case NotifyEvent.UPDATE_NOTE:
//                if (event.getData() instanceof SNote) {
//                    SNote note = (SNote) event.getData();
//                    view.updateNote(note);
//                    view.scrollRecyclerViewToTop();
//                    pushNote(note);
//                }
                break;
            case NotifyEvent.CHANGE_THEME:
                recreate();
                break;
        }
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

//    @Override
//    public void reCreate() {
//        super.recreate();
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
