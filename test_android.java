package com.example.myapplication;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class Mycanvas extends View {
    private Paint paint;
    private Path path;
    public Mycanvas(Context context) {
        super(context);
     path = new Path();
     paint =new Paint();
     paint =setColor(Color.blue);
     paint =setStrokeWitdh(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x= event.getX();
        float y =event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
            path.moveTo(x,y);
             invalidate();
             break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                invalidate();
                break;
            case Motionevent.ACTION_UP:
                break;
            }
        return true;
    }
     public void clearCanvas(){
        path.reset();
        invalidate();
     }
}
