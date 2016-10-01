package brad.tw.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by user on 2016/10/1.
 */
public class MyView extends View {
    private LinkedList<HashMap<String,Float>> line;


    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW);

        setOnClickListener(new MyClickListener());
        line = new LinkedList<>();

    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Log.d("brad","onClick");
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float ex = event.getX(), ey = event.getY();

        if (event.getAction() == MotionEvent.ACTION_UP){
        }else if (event.getAction() == MotionEvent.ACTION_DOWN){
            doDown(event);
        }else if (event.getAction() == MotionEvent.ACTION_MOVE){
            doMove(event);
        }
        return true;
    }

    private void doDown(MotionEvent event){
        HashMap<String,Float> point = new HashMap<>();
        point.put("x",event.getX());
        point.put("y",event.getY());
        line.add(point);
    }

    private void doMove(MotionEvent event){
        HashMap<String,Float> point = new HashMap<>();
        point.put("x",event.getX());
        point.put("y",event.getY());
        line.add(point);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(100,100,40,paint);

        paint.setStrokeWidth(4);
        paint.setColor(Color.BLUE);
        canvas.drawLine(0,0,200,200,paint);
    }


}
