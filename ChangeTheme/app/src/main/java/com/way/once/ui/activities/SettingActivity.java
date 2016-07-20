package com.way.once.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.way.once.adapters.ColorsListAdapter;
import com.way.once.NotifyEvent;
import com.way.once.R;
import com.way.once.utils.DialogUtils;
import com.way.once.utils.PreferenceUtils;
import com.way.once.utils.ThemeUtils;

import java.util.Arrays;
import java.util.List;

import de.greenrobot.event.EventBus;

public class SettingActivity extends BaseActivity {
    private final static String TAG = SettingActivity.class.getName();

    Toolbar toolbar;
    TextView tvChangeTheme;
    NotifyEvent<Void> event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_setting;
    }

    @Override
    protected void initViewID() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tvChangeTheme = (TextView) findViewById(R.id.tv_change_theme);
    }

    @Override
    protected void initViewData() {
        tvChangeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = DialogUtils.makeDialogBuilder(SettingActivity.this);
                builder.setTitle(R.string.change_theme);
                Integer[] res = new Integer[]{R.drawable.red_round, R.drawable.brown_round, R.drawable.blue_round,
                        R.drawable.blue_grey_round, R.drawable.yellow_round, R.drawable.deep_purple_round,
                        R.drawable.pink_round, R.drawable.green_round};
                List<Integer> list = Arrays.asList(res);
                ColorsListAdapter adapter = new ColorsListAdapter(SettingActivity.this, list);
                adapter.setCheckItem(ThemeUtils.getCurrentTheme(SettingActivity.this).getIntValue());
                GridView gridView = (GridView) LayoutInflater.from(SettingActivity.this).inflate(R.layout.colors_panel_layout, null);
                gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
                gridView.setCacheColorHint(0);
                gridView.setAdapter(adapter);
                builder.setView(gridView);
                final AlertDialog dialog = builder.show();
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        dialog.dismiss();
                        int value = ThemeUtils.getCurrentTheme(SettingActivity.this).getIntValue();
                        if (value != position) {
                            PreferenceUtils.getInstance(SettingActivity.this).saveParam(getString(R.string.change_theme_key), position);
                            notifyChangeTheme();
                        }
                    }
                });
            }
        });
    }

    private void notifyChangeTheme() {
        if (event == null) {
            event = new NotifyEvent<>();
        }
        event.setType(NotifyEvent.CHANGE_THEME);
        //post change theme event immediately
        EventBus.getDefault().post(event);
        reload(false);
    }

    public void onEventMainThread(NotifyEvent event1){
        Log.d(TAG, "onEventMainThread debug");
        if (event == null){
            event = new NotifyEvent<>();
        }
    }

    @Override
    protected void initToolbar() {
        super.initToolbar(toolbar);
        toolbar.setTitle(R.string.setting);
    }

    @Override
    public void onDestroy() {
        if (event != null && event.getType() != NotifyEvent.CHANGE_THEME) {
            EventBus.getDefault().post(event);
        }
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

}
