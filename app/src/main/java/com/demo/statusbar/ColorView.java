package com.demo.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Created by chengli on 15/6/8.
 * 普通的view，也是直接设置background属性来达到设置样式
 */
public class ColorView extends View implements SelectColorsWindow.OnItemClickListener {

    private static final String TAG = ColorView.class.getSimpleName();
    private int attr_background = -1;

    public ColorView(Context context) {
        super(context);
    }

    public ColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setMyTheme(int index) {

    }


    @Override
    public void ItemClick(Resources.Theme theme) {
        Log.d(TAG, "ItemClick");
        if (attr_background != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, theme, attr_background);
        }
    }

}
