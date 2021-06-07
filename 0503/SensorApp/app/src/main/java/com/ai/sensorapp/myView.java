/*
*
* */

package com.ai.sensorapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

public class myView extends View {

    // SIMILAR TO BITMAP
    private Drawable cockatoo;

    private int imageWidth;
    private int imageHeight;

    // COORDINATES FOR UPPER LEFT
    private float x;
    private float y;

    public myView(Context context) {
        super(context);
        // LOADING IMAGE
        cockatoo = getResources().getDrawable(R.drawable.cockatoo);

        x = 10; y = 10;
        imageWidth = 200;
        imageHeight = 200;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // COORDINATES FOR BOTTOM RIGHT
        int xx = (int)x;
        int yy = (int)y;

        // SETTINGS BEFORE DRAWING
        cockatoo.setBounds(xx,yy, xx + imageWidth, yy + imageHeight);

        // DRAW
        cockatoo.draw(canvas);
    }

    // 화면 업데이트
    public void move(float mx, float my)
    {
        int viewWidth = getWidth();
        int viewHeight = getHeight();

        x = (mx * 4f);// x + 1;
        y = (my * 4f); // y + 2;

        // 이미지가 넘어가지 않게 작업
        if (x < 0) {x = 0;}
        else if((x + imageWidth) > viewWidth) { x = viewWidth - imageWidth;}

        if (y < 0) {y = 0;}
        else if((y + imageHeight) > viewHeight) {y = viewHeight - imageHeight;}

        // CALLS onDraw
        invalidate();
        // INVALIDATE : IN ORDER
        // POST INVALIDATE : INVALIDATE FIRST
    }
}
