package com.example.demo.tim.plane;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private int speed = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final PlaneView planeView = new PlaneView(this);
        setContentView(planeView);
        planeView.setBackgroundResource(R.drawable.back);
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        planeView.currentX = displayMetrics.widthPixels / 2;
        planeView.currentY = displayMetrics.heightPixels - 40;
        planeView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getKeyCode()){
                    case KeyEvent.KEYCODE_S :
                        planeView.currentY += speed;
                        break;
                    case KeyEvent.KEYCODE_W :
                        planeView.currentY -= speed;
                        break;
                    case KeyEvent.KEYCODE_A :
                        planeView.currentX -= speed;
                        break;
                    case KeyEvent.KEYCODE_D :
                        planeView.currentX += speed;
                        break;
                }
                planeView.invalidate();
                return  true;
            }
        });

    }
}
