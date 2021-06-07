package kr.ai.gesture;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class GestureView  extends View {

    private Bitmap cockatoo;
    private int x;
    private int y;
    private final int STEP = 50;

    public GestureView(Context context)
    {
        super(context);

        cockatoo = BitmapFactory.decodeResource(getResources(),R.drawable.cockatoo);

        x = 80;
        y = 80;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(cockatoo,x,y,null);
        super.onDraw(canvas);
    }

    public void drawImage(int x, int y)
    {
        this.x = x;
        this.y = y;
        // onDraw() 실행해준다
        invalidate();
    }

    public void moveLeft()
    {
        x -= STEP; invalidate();
    }

    public void moveRight()
    {
        x += STEP; invalidate();
    }

    public void moveUp()
    {
        y -= STEP; invalidate();
    }

    public void moveDown()
    {
        y += STEP; invalidate();
    }
}
