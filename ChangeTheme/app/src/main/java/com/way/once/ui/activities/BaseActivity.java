package com.way.once.ui.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.way.once.R;
import com.way.once.utils.ThemeUtils;
import com.way.once.utils.ToolbarUtils;

/**
 * Created by pc on 2016/7/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        parseIntent(getIntent());
//        showActivityInAnim();
        initTheme();
        super.onCreate(savedInstanceState);
        initWindow();
        //initializeDependencyInjector();
        setContentView(getLayoutView());
        initViewID();
        //ButterKnife.bind(this);
        initToolbar();
        initViewData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initTheme(){
        ThemeUtils.Theme theme = ThemeUtils.getCurrentTheme(this);
        ThemeUtils.changeTheme(this, theme);
    }

    @TargetApi(19)
    private void initWindow(){
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintColor(getStatusBarColor());
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    public int getStatusBarColor(){
        return getColorPrimary();
    }

    public int getColorPrimary(){
        TypedValue typedValue = new  TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        return typedValue.data;
    }

    protected abstract @LayoutRes
    int getLayoutView();

    protected abstract void initViewID();
    protected abstract void initViewData();

    protected void initToolbar(){

    }

    public void reload(boolean anim) {
        finish();
        Intent intent = getIntent();
        startActivity(intent);
    }

    protected void initToolbar(Toolbar toolbar){
        ToolbarUtils.initToolbar(toolbar, this);
    }

    @Override
    public void finish() {
        super.finish();
//        showActivityExitAnim();
    }

}
