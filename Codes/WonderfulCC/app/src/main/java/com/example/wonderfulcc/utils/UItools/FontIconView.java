package com.example.wonderfulcc.utils.UItools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * @author Shiyun Zhu
 */
@SuppressLint("AppCompatCustomView")
public class FontIconView extends TextView {
    public FontIconView(Context context) {
        super(context);
        init(context);
    }
    public FontIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public FontIconView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }
    /**
     *init
     * @param context context
     */
    private void init(Context context) {
        //set font icon
        Typeface font = Typeface.createFromAsset(context.getAssets(), "iconfont.ttf");
        this.setTypeface(font);
    }
}


