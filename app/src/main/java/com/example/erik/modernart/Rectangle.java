package com.example.erik.modernart;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;



public class Rectangle {

    private final View mView;
    private final int mInitialColor;
    private int mFinalColor;


    public Rectangle(View view, int initialColor, int finalColor) {
        mView = view;
        mInitialColor = initialColor;
        mFinalColor = finalColor;
    }

    public void setColor(int color) {
        mView.setBackgroundColor(color);
    }

    public int getInitialColor() {
        return mInitialColor;
    }

    public int getFinalColor() {
        return mFinalColor;
    }

    public int getRedGradient() {
        return Color.red(mFinalColor) - Color.red(mInitialColor);
    }

    public int getGreenGradient() {
        return Color.green(mFinalColor) - Color.green(mInitialColor);
    }
    public int getBlueGradient() {
        return Color.blue(mFinalColor) - Color.blue(mInitialColor);
    }


}



