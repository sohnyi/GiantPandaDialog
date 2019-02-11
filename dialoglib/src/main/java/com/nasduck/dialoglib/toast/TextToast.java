package com.nasduck.dialoglib.toast;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nasduck.dialoglib.base.BaseToast;
import com.nasduck.dialoglib.R;
import com.nasduck.dialoglib.config.ToastTextConfig;

public class TextToast extends BaseToast {

    private TextView mTvContent;
    private FrameLayout mLayoutBackground;

    private ToastTextConfig mConfig;

    public TextToast() {}

    public static TextToast create(ToastTextConfig config) {
        TextToast fragment = new TextToast();
        Bundle args = new Bundle();
        args.putParcelable("textToastConfig", config);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mConfig = getArguments().getParcelable("textToastConfig");
        }
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.toast_text;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        mTvContent = view.findViewById(R.id.tv_content);
        mLayoutBackground = view.findViewById(R.id.background);

        updateUI(this.mConfig);
    }

    public void updateUI(ToastTextConfig config) {
        // Corner Radius && Background Color
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(config.getCornerRadius());
        drawable.setColor(mContext.getResources().getColor(config.getBackgroundColor()));
        mLayoutBackground.setBackground(drawable);

        // Text
        mTvContent.setText(config.getText());

        // Text Size
        mTvContent.setTextSize(config.getTextSize());

        // Text Color
        mTvContent.setTextColor(getResources().getColor(config.getTextColor()));

        // Padding
        mLayoutBackground.setPadding(config.getPaddingHorizontal(), config.getPaddingVertical(),
                config.getPaddingHorizontal(), config.getPaddingVertical());
    }

}
