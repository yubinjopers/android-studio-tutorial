package kr.ai.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View implements Runnable{
    private BitmapDrawable image;
    private int imageWidth = 200;
    private int imageHeight = 200;
    private int x;
    private int y;
    private int viewWidth;
    private int viewHeight;

    public MyView(Context context) {
        super(context);

        image =(BitmapDrawable) this.getResources().getDrawable(R.drawable.grandpadog);

        Thread thread = new Thread(this);
        thread.start();
    }

    // myView 크기가 변경되면 호출
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        viewWidth = this.getWidth();
        viewHeight = getHeight();

        x = viewWidth/2 - imageWidth/2;
        y = viewHeight/2 - imageHeight/2;

        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        image.setBounds(x,y,x+imageWidth,y+imageHeight);

        // 이미지 위치 선정
        image.draw(canvas);
        super.onDraw(canvas);
    }
    @Override

    public boolean onTouchEvent(MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        this.invalidate(); // onDraw() call

        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_BACK:
                x-= 50;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                y-=50;
                break;
        }
        // 화면 다시 그리기
        invalidate();
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                {
                    Thread.sleep(500);
                    y+=50;
                    y = Math.min(viewHeight-imageHeight,y);

                    //invalidate();196
                    postInvalidate();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
