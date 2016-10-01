package brad.tw.myviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = (MyView)findViewById(R.id.myView);
    }

    public void clearMyView(View v){
        myView.clear();
    }
    public void undoMyView(View v){
        myView.undo();
    }
    public void redoMyView(View v){
        myView.redo();
    }
}
