package com.nasduck.dialoglib.builder.dialog.footer;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.nasduck.dialoglib.R;
import com.nasduck.dialoglib.interfaces.IDialogFooter;
import com.nasduck.dialoglib.config.DialogConfig;
import com.nasduck.dialoglib.dialog.composition.footer.TwoButtonFooter;
import com.nasduck.dialoglib.interfaces.OnNegativeClickListener;
import com.nasduck.dialoglib.interfaces.OnPositiveClickListener;

public class TwoButtonFooterBuilder implements IDialogFooter {

    private OnPositiveClickListener positiveClickListener;
    private OnNegativeClickListener negativeClickListener;

    private float cornerRadius;
    private int backgroundColor;
    private int clickBackgroundColor;

    private String positiveButtonText;
    private int positiveButtonTextColor;
    private int positiveButtonTextSize;

    private String negativeButtonText;
    private int negativeButtonTextColor;
    private int negativeButtonTextSize;

    public TwoButtonFooterBuilder() {
        cornerRadius = 0f;
        clickBackgroundColor = R.color.gray_light;

        positiveButtonText = "confirm";
        positiveButtonTextColor = R.color.text_black;
        positiveButtonTextSize = 16;
        positiveClickListener = null;

        negativeButtonText = "cancel";
        negativeButtonTextColor = R.color.text_black;
        negativeButtonTextSize = 16;
        negativeClickListener = null;
    }

    public static TwoButtonFooterBuilder create() {
        return new TwoButtonFooterBuilder();
    }

    @Override
    public View getView(FragmentActivity activity, Context context, String tag) {
        return TwoButtonFooter.create(activity, context, new DialogConfig(TwoButtonFooterBuilder.this), tag);
    }

    @Override
    public void getCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void getNormalStatusColor(int color) {
        this.backgroundColor = color;
    }

    /**********************************************************************************************/

    public TwoButtonFooterBuilder setClickBackgroundColor(Integer clickBackgroundColor) {
        if (clickBackgroundColor != null) {
            this.clickBackgroundColor = clickBackgroundColor;
        }
        return this;
    }

    public TwoButtonFooterBuilder setPositiveClickListener(OnPositiveClickListener positiveClickListener) {
        if (positiveClickListener != null) {
            this.positiveClickListener = positiveClickListener;
        }
        return this;
    }

    public TwoButtonFooterBuilder setNegativeClickListener(OnNegativeClickListener negativeClickListener) {
        if (negativeClickListener != null) {
            this.negativeClickListener = negativeClickListener;
        }
        return this;
    }

    public TwoButtonFooterBuilder setPositiveButtonText(String positiveButtonText) {
        if (positiveButtonText != null) {
            this.positiveButtonText = positiveButtonText;
        }
        return this;
    }

    public TwoButtonFooterBuilder setPositiveButtonTextColor(Integer positiveButtonTextColor) {
        if (positiveButtonTextColor != null) {
            this.positiveButtonTextColor = positiveButtonTextColor;
        }
        return this;
    }

    public TwoButtonFooterBuilder setPositiveButtonTextSize(Integer positiveButtonTextSize) {
        if (positiveButtonTextSize != null) {
            this.positiveButtonTextSize = positiveButtonTextSize;
        }
        return this;
    }

    public TwoButtonFooterBuilder setNegativeButtonText(String negativeButtonText) {
        if (negativeButtonText != null) {
            this.negativeButtonText = negativeButtonText;
        }
        return this;
    }

    public TwoButtonFooterBuilder setNegativeButtonTextColor(Integer negativeButtonTextColor) {
        if (negativeButtonTextColor != null) {
            this.negativeButtonTextColor = negativeButtonTextColor;
        }
        return this;
    }

    public TwoButtonFooterBuilder setNegativeButtonTextSize(Integer negativeButtonTextSize) {
        if (negativeButtonTextSize != null) {
            this.negativeButtonTextSize = negativeButtonTextSize;
        }
        return this;
    }

    /**********************************************************************************************/

    public float getCornerRadius() {
        return cornerRadius;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getClickBackgroundColor() {
        return clickBackgroundColor;
    }

    public OnPositiveClickListener getPositiveClickListener() {
        return positiveClickListener;
    }

    public OnNegativeClickListener getNegativeClickListener() {
        return negativeClickListener;
    }

    public String getPositiveButtonText() {
        return positiveButtonText;
    }

    public int getPositiveButtonTextColor() {
        return positiveButtonTextColor;
    }

    public int getPositiveButtonTextSize() {
        return positiveButtonTextSize;
    }

    public String getNegativeButtonText() {
        return negativeButtonText;
    }

    public int getNegativeButtonTextColor() {
        return negativeButtonTextColor;
    }

    public int getNegativeButtonTextSize() {
        return negativeButtonTextSize;
    }
}
