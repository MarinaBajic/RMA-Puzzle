package com.example.puzzle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillId;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout mImageContainer;
        ImageView mImageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageContainer = itemView.findViewById(R.id.imgContainer);
            mImageView = itemView.findViewById(R.id.img);
            System.out.println("nova: " + mImageView.toString());
            originalPuzzle.add(mImageView);
        }
    }

    private Context context;

    private List<Integer> puzzle;

    protected static List<ImageView> originalPuzzle;


    public MyAdapter(Context context, List<Integer> puzzle) {
        this.context = context;
        this.puzzle = puzzle;
        originalPuzzle = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mImageView.setImageResource(puzzle.get(position));
        holder.mImageView.setOnTouchListener(new MyTouchListener());
        holder.mImageContainer.setOnDragListener(new MyDragListener(originalPuzzle));
        System.out.println("ogpuzla: " + originalPuzzle.toString());
    }

    @Override
    public int getItemCount() {
        return puzzle.size();
    }

}
