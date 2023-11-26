package com.example.puzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private List<Integer> puzzle;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrecyclerView = findViewById(R.id.recyclerView);
        puzzle = new ArrayList<>();
        mAdapter = new MyAdapter(this, puzzle);

        puzzle.add(R.drawable.android00);
        puzzle.add(R.drawable.android01);
        puzzle.add(R.drawable.android02);
        puzzle.add(R.drawable.android10);
        puzzle.add(R.drawable.android11);
        puzzle.add(R.drawable.android12);
        puzzle.add(R.drawable.android20);
        puzzle.add(R.drawable.android21);
        puzzle.add(R.drawable.android22);
        puzzle.add(R.drawable.android30);
        puzzle.add(R.drawable.android31);
        puzzle.add(R.drawable.android32);

        Collections.shuffle(puzzle);

        GridLayoutManager glm = new GridLayoutManager(this, 3);
        mrecyclerView.setLayoutManager(glm);
        mrecyclerView.setAdapter(mAdapter);
    }
}