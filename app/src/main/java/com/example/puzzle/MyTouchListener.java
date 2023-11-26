package com.example.puzzle;

import android.content.ClipData;
import android.view.MotionEvent;
import android.view.View;

public class MyTouchListener implements View.OnTouchListener {

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    view);
            view.startDrag(data, shadowBuilder, view, 0);
            view.setVisibility(View.VISIBLE);
            return true;
        } else {
            return false;
        }
    }
}
