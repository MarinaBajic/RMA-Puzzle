package com.example.puzzle;

import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MyDragListener implements View.OnDragListener {

    private List<ImageView> originalPuzzle;
    private List<ImageView> workingPuzzle;

    public MyDragListener(List<ImageView> originalPuzzle) {
        this.originalPuzzle = originalPuzzle;
        this.workingPuzzle = new ArrayList<>(originalPuzzle);
    }

    @Override
    public boolean onDrag(View v, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case DragEvent.ACTION_DROP:
                ImageView imageFrom = (ImageView) dragEvent.getLocalState();
                ViewGroup containerFrom = (ViewGroup) imageFrom.getParent();
                LinearLayout containerTo = (LinearLayout) v;
                ImageView imageTo = (ImageView) containerTo.getChildAt(0);
                System.out.println("imagev: " + imageFrom.toString());
                System.out.println("imagev2: " + imageTo.toString());

                if (imageFrom.equals(imageTo))
                    break;

                containerFrom.removeView(imageFrom);
                containerTo.removeView(imageTo);
                containerFrom.addView(imageTo);
                containerTo.addView(imageFrom);

//                Collections.swap(workingPuzzle, workingPuzzle.indexOf(imageFrom), workingPuzzle.indexOf(imageTo));

                System.out.println("workingpzle: " + workingPuzzle.toString());
                System.out.println("ogPuzle: " + originalPuzzle.toString());

                checkIfComplete();
                break;
        }
        return true;
    }

    public boolean checkIfComplete() {
        for (int i = 0; i < workingPuzzle.size(); i++) {
            if (!workingPuzzle.get(i).equals(originalPuzzle.get(i))) {
                System.out.println("Jos malooo");
                return false;
            }

        }
        System.out.println("Cestitaamm!");
        System.out.println(originalPuzzle.toString());
        System.out.println("wp:" + workingPuzzle.toString());

        return true;
    }
}
