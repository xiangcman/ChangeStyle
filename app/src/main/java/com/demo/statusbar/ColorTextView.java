package com.demo.statusbar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;


/**
 * Created by chengli on 15/6/8.
 */
public class ColorTextView extends TextView implements SelectColorsWindow.OnItemClickListener {

    private int attr_drawable = -1;
    private int attr_textColor = -1;
    private int attr_textLinkColor = -1;

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.attr_drawable = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);
        this.attr_textLinkColor = ViewAttributeUtil.getTextLinkColorAttribute(attrs);
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attr_drawable = ViewAttributeUtil.getBackgroundAttibute(attrs);
        this.attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);
        this.attr_textLinkColor = ViewAttributeUtil.getTextLinkColorAttribute(attrs);
    }

    @Override
    public void ItemClick(Resources.Theme theme) {
        if (attr_drawable != -1) {
            ViewAttributeUtil.applyBackgroundDrawable(this, theme, attr_drawable);
        }
        if (attr_textColor != -1) {
            ViewAttributeUtil.applyTextColor(this, theme, attr_textColor);
        }
        if (attr_textLinkColor != -1) {
            ViewAttributeUtil.applyTextLinkColor(this, theme, attr_textLinkColor);
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
