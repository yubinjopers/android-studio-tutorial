package kr.ai.gesture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private static final int FLING_MIN_DISTANCE = 100;
    private static final int FLING_LIMIT_VELOCITY = 200;

    // 제스처를 처리해줄 클래스
    private GestureDetector gestureDetector;
    final String TAG = "MainActivity";

    // 화면 클래스
    GestureView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureDetector = new GestureDetector(this, this);

        myView = new GestureView(this);

        setContentView(myView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 제스처 처리를 위해서 gestureDetector한테 넘겨준다
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        Log.i(TAG, "onDown() x : " + x + " y : " + y);

        myView.drawImage((int)e.getX(),(int)e.getY());
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Log.i(TAG, "onShowPress()");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.i(TAG, "onSingleTapUp()");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.i(TAG, "onScroll()");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Log.i(TAG, "onLongPress()");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.i(TAG, "onFling() e1.x : " + e1.getX() + "e1.y : " + e1.getY());
        Log.i(TAG, "onFling() e2.x : " + e2.getX() + "e2.y : " + e2.getY());

        // UP, DOWN, LEFT, RIGHT 이동 검증
        if((e1.getX()-e2.getX() > FLING_MIN_DISTANCE) && (Math.abs(velocityX) > FLING_LIMIT_VELOCITY))
        {
            myView.moveLeft();
            Log.i(TAG, "LEFT");
        }
        else if((e2.getX() - e1.getX() > FLING_MIN_DISTANCE) &&(Math.abs(velocityX) > FLING_LIMIT_VELOCITY))
        {
            myView.moveRight();
            Log.i(TAG, "RIGHT");
        }
        else if((e1.getY()-e2.getY() > FLING_MIN_DISTANCE)&&(Math.abs(velocityY) > FLING_LIMIT_VELOCITY))
        {
            myView.moveUp();
            Log.i(TAG, "UP");
        }
        else if((e2.getY()-e1.getY() > FLING_MIN_DISTANCE)&&(Math.abs(velocityY) > FLING_LIMIT_VELOCITY))
        {
            myView.moveDown();
            Log.i(TAG, "DOWN");
        }

        return false;
    }
}