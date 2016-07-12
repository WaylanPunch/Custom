package com.way.contextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    TextView tvTip;
    ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTip = (TextView) findViewById(R.id.tv_tip);
        ivMenu = (ImageView) findViewById(R.id.iv_menu);

        this.registerForContextMenu(ivMenu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        Log.i(TAG, "onCreateContextMenu debug");
        // set context menu title
        menu.setHeaderTitle("文件操作");
        // add context menu item
        menu.add(0, 1, Menu.NONE, "发送");
        menu.add(0, 2, Menu.NONE, "标记为重要");
        menu.add(0, 3, Menu.NONE, "重命名");
        menu.add(0, 4, Menu.NONE, "删除");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // 得到当前被选中的item信息
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //Log.i(TAG, "onContextItemSelected debug, MenuInfo id = " + menuInfo.id);
        switch (item.getItemId()) {
            case 1:
                // do something
                Log.i(TAG, "onContextItemSelected debug, MenuItem ID = " + 1);
                break;
            case 2:
                // do something
                Log.i(TAG, "onContextItemSelected debug, MenuItem ID = " + 2);
                break;
            case 3:
                // do something
                Log.i(TAG, "onContextItemSelected debug, MenuItem ID = " + 3);
                break;
            case 4:
                // do something
                Log.i(TAG, "onContextItemSelected debug, MenuItem ID = " + 4);
                break;
            default:
                // do something
                Log.i(TAG, "onContextItemSelected debug, MenuItem ID = " + item.getItemId());
                return super.onContextItemSelected(item);
        }
        return true;
    }
}
