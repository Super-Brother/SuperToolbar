package com.example.supertoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Toolbar extends RelativeLayout {

    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvTitle;
    private int mTextColor = Color.WHITE;
    private String title;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.Toolbar);
        mTextColor = mTypedArray.getColor(R.styleable.Toolbar_title_text_color, Color.WHITE);
        title = mTypedArray.getString(R.styleable.Toolbar_title_text);
        //获取资源后要回收
        mTypedArray.recycle();

        LayoutInflater.from(context).inflate(R.layout.titlebar, this, true);
        ivLeft = findViewById(R.id.iv_titlebar_left);
        ivRight = findViewById(R.id.iv_titlebar_right);
        tvTitle = findViewById(R.id.tv_titlebar_title);
        tvTitle.setTextColor(mTextColor);
        setTitle(title);
    }

    public void setLeftListener(OnClickListener onClickListener) {
        ivLeft.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener) {
        ivRight.setOnClickListener(onClickListener);
    }

    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
    }
}
