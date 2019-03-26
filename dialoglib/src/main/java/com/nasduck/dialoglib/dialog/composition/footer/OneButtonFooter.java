package com.nasduck.dialoglib.dialog.composition.footer;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.nasduck.dialoglib.R;
import com.nasduck.dialoglib.dialog.config.DialogConfig;
import com.nasduck.dialoglib.base.DuckDialog;
import com.nasduck.dialoglib.base.utils.DensityUtils;

public class OneButtonFooter extends RelativeLayout {

    private static FragmentActivity mActivity;
    private static DialogConfig mConfig;
    private static String mTag;

    public static OneButtonFooter create(FragmentActivity activity, Context context, DialogConfig config, String tag) {
        mActivity = activity;
        mConfig = config;
        mTag = tag;
        return new OneButtonFooter(context);
    }

    public OneButtonFooter(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_footer_button_one, this);
        Button btnNormal = view.findViewById(R.id.btn_normal);

        // button click effect
        float radius = mConfig.getCornerRadius();

        GradientDrawable drawablePressed = new GradientDrawable();
        drawablePressed.setCornerRadii(new float[]{0f, 0f, 0f, 0f,
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius)});
        drawablePressed.setColor(getResources().getColor(mConfig.getClickBackgroundColor()));

        GradientDrawable drawableNormal = new GradientDrawable();
        drawableNormal.setCornerRadii(new float[]{0f, 0f, 0f, 0f,
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius),
                DensityUtils.dp2px(context, radius)});
        drawableNormal.setColor(getResources().getColor(mConfig.getBackgroundColor()));

        StateListDrawable drawableList = new StateListDrawable();
        drawableList.addState(new int[]{android.R.attr.state_pressed}, drawablePressed);
        drawableList.addState(new int[]{}, drawableNormal);

        btnNormal.setBackground(drawableList);

        // button text style
        btnNormal.setText(mConfig.getNormalButtonText());
        btnNormal.setTextColor(getResources().getColor(mConfig.getNormalButtonTextColor()));
        btnNormal.setTextSize(mConfig.getNormalButtonTextSize());

        // button click
        btnNormal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mConfig.getNormalClickListener() != null) {
                    mConfig.getNormalClickListener().onNormalClick();
                }
                DuckDialog.hide(mActivity, mTag);
            }
        });
    }
}
