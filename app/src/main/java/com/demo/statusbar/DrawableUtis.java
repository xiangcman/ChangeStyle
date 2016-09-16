package com.demo.statusbar;

import android.graphics.drawable.GradientDrawable;

/**
 * Created by xiangcheng on 16/9/13.
 */
public class DrawableUtis {
    public static GradientDrawable createShape(int color) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.OVAL);
        drawable.setColor(color);// 设置颜色
        return drawable;


    }
}
