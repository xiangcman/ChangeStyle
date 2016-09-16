package com.demo.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;


/**
 * Created by chengli on 15/6/8.
 */
public class ColorRelativeLayout extends RelativeLayout implements SelectColorsWindow.OnItemClickListener {

    private int attr_background = -1;

    public ColorRelativeLayout(Context context) {
        super(context);
    }

    public ColorRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public ColorRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //这里是获取background属性的值
        this.attr_background = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public void ItemClick(Resources.Theme theme) {
        if (attr_background != -1) {
            //这里的themeId对应的是哪个style，最后的一个参数是对应该style中的属性名
            ViewAttributeUtil.applyBackgroundDrawable(this, theme, attr_background);
        }
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void setMyTheme(int index) {

    }


}
