package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecyclerBaseActivity extends AppCompatActivity {

    RecyclerView recyclerViewBase;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_base);

        recyclerViewBase = findViewById(R.id.recyclerViewBase);

        list.clear();
        list.add("1 - 첫번째 기본 아이템");
        list.add("2 - 두번째 기본 아이템");
        list.add("3 - 세번쨰 기본 아이템");

        RecyclerBaseAdapter adapter = new RecyclerBaseAdapter(list);
        // ctrl + alt + v
        recyclerViewBase.setAdapter(adapter);
        recyclerViewBase.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.baseAddBtn).setOnClickListener(v -> {
            list.add("추가된 아이템");

            adapter.notifyItemInserted(list.size()-1);
        });

    }
}