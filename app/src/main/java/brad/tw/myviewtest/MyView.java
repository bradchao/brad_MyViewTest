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
    private LinkedList<LinkedList<HashMap<String,Float>>>
        lines, recycle;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW);

        setOnClickListener(new MyClickListener());
        lines = new LinkedList<>();
        recycle = new LinkedList<>();

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
        recycle.clear();

        LinkedList<HashMap<String,Float>> line = new LinkedList<>();
        lines.add(line);

        HashMap<String,Float> point = new HashMap<>();
        point.put("x",event.getX());
        point.put("y",event.getY());
        lines.getLast().add(point);


    }

    private void doMove(MotionEvent event){
        HashMap<String,Float> point = new HashMap<>();
        point.put("x",event.getX());
        point.put("y",event.getY());
        lines.getLast().add(point);

        invalidate();   // onDraw() like repaint()
    }

    public void clear(){
        lines.clear();
        invalidate();
    }
    public void undo(){
        if (lines.size()>0) {
            recycle.add(lines.removeLast());
            invalidate();
        }
    }
    public void redo(){
        if (recycle.size()>0) {
            lines.add(recycle.removeLast());
            invalidate();
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setStrokeWidth(4);
        paint.setColor(Color.BLUE);

        for(LinkedList<HashMap<String,Float>> line : lines) {
            for (int i = 1; i < line.size(); i++) {
                HashMap<String, Float> p0 = line.get(i - 1);
                HashMap<String, Float> p1 = line.get(i);
                canvas.drawLine(p0.get("x"), p0.get("y"),
                        p1.get("x"), p1.get("y"), paint);
            }
        }
    }


}
