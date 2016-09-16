package com.demo.statusbar;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectColorsWindow.OnItemClickListener {
    private LinearLayout main;
    ColorView mStatusBar;
    private int checked;
    private ColorRelativeLayout toolBar;
    private ColorTextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        setContentView(R.layout.activity_main);
        main = (LinearLayout) findViewById(R.id.main);
        mStatusBar = (ColorView) findViewById(R.id.status_bar);
        toolBar = (ColorRelativeLayout) findViewById(R.id.toolbar);
        mText = (ColorTextView) findViewById(R.id.main_text);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mStatusBar.setVisibility(View.VISIBLE);
            //让该view的高度正好等于状态栏的高度
            mStatusBar.getLayoutParams().height = SystemUtils.getStatusHeight(this);
            mStatusBar.setLayoutParams(mStatusBar.getLayoutParams());
        } else {
            mStatusBar.setVisibility(View.GONE);
        }

        findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<SelectColorsWindow.OnItemClickListener> listeners = new ArrayList<>();
                listeners.add(mStatusBar);
                listeners.add(toolBar);
                listeners.add(mText);
                SelectColorsWindow selectColorsWindow = new SelectColorsWindow(MainActivity.this, checked, listeners, getTheme());
                selectColorsWindow.showAtLocation(main, Gravity.BOTTOM
                        | Gravity.CENTER_HORIZONTAL, 0, 0);
                selectColorsWindow.setListener(MainActivity.this);
            }
        });

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    public void ItemClick(Resources.Theme theme) {
    }


    @Override
    public View getView() {
        return null;
    }

    @Override
    public void setMyTheme(int index) {
        setTheme(ThemeUtils.getTheme(index));
        checked = index;
    }
}
