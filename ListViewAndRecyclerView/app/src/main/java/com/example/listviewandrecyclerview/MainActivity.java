package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.listBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.baseBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerBaseActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.recyclerBtn).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RecyclerListActivity.class);
            startActivity(intent);
        });

    }
}