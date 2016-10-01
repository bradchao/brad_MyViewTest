package brad.tw.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by user on 2016/10/1.
 */
public class MyView extends View {
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW);

        setOnClickListener(new MyClickListener());

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
        Log.d("brad", "onTouch:" + ex + ":" + ey);
        //super.onTouchEvent(event);
        return true;
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
