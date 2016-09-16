package com.demo.statusbar;


import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by chengli on 15/6/8.
 */
public class ViewAttributeUtil {

    public static int getAttributeValue(AttributeSet attr, int paramInt) {
        int value = -1;
        int count = attr.getAttributeCount();
        for (int i = 0; i < count; i++) {
            if (attr.getAttributeNameResource(i) == paramInt) {
                String str = attr.getAttributeValue(i);
                if (null != str && str.startsWith("?")) {
                    /**
                     * 从第二位开始获取
                     */
                    value = Integer.valueOf(str.substring(1, str.length())).intValue();
                    return value;
                }
            }
        }
        return value;
    }

    public static int getBackgroundAttibute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.background);
    }

    public static int getCheckMarkAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.checkMark);
    }

    public static int getSrcAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.src);
    }

    public static int getTextApperanceAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.textAppearance);
    }

    public static int getDividerAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.divider);
    }

    public static int getTextColorAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.textColor);
    }

    public static int getTextLinkColorAttribute(AttributeSet attr) {
        return getAttributeValue(attr, android.R.attr.textColorLink);
    }

    public static void applyBackgroundDrawable(SelectColorsWindow.OnItemClickListener ci, Resources.Theme theme, int paramInt) {
        //这里是获取style的theme的某一个item
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        Drawable drawable = ta.getDrawable(0);
        /**
         * 实际上是给控件设置background属性
         */
        if (null != ci) {
            //这里如果要设置控件背景的话，需要去实现ColorUiInterface接口，因为只有实现了该接口，才能拿到当前的view
            (ci.getView()).setBackgroundDrawable(drawable);
        }
        ta.recycle();
    }

    public static void applyImageDrawable(SelectColorsWindow.OnItemClickListener ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        Drawable drawable = ta.getDrawable(0);
        if (null != ci && ci instanceof ImageView) {
            ((ImageView) ci.getView()).setImageDrawable(drawable);
        }
        ta.recycle();
    }

    public static void applyTextAppearance(SelectColorsWindow.OnItemClickListener ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        int resourceId = ta.getResourceId(0, 0);
        if (null != ci && ci instanceof TextView) {
            ((TextView) ci.getView()).setTextAppearance(ci.getView().getContext(), resourceId);
        }
        ta.recycle();
    }

    public static void applyTextColor(SelectColorsWindow.OnItemClickListener ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        //这里取的是style的第-个item的值
        int resourceId = ta.getColor(0, 0);
        if (null != ci && ci instanceof TextView) {
            ((TextView) ci.getView()).setTextColor(resourceId);
        }
        ta.recycle();
    }

    public static void applyTextLinkColor(SelectColorsWindow.OnItemClickListener ci, Resources.Theme theme, int paramInt) {
        TypedArray ta = theme.obtainStyledAttributes(new int[]{paramInt});
        int resourceId = ta.getColor(0, 0);
        if (null != ci && ci instanceof TextView) {
            ((TextView) ci.getView()).setLinkTextColor(resourceId);
        }
        ta.recycle();
    }

}
