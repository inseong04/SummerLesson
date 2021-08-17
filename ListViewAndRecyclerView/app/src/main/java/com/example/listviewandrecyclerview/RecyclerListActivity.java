package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecyclerListActivity extends AppCompatActivity {

    RecyclerView recyclerViewList;
    Button listAddBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list);

        recyclerViewList = findViewById(R.id.recyclerViewList);
        listAddBtn = findViewById(R.id.listAddBtn);


/*        list.clear();
        list.add("1 - 첫번째 기본 아이템");
        list.add("2 - 두번째 기본 아이템");
        list.add("3 - 세번쨰 기본 아이템");*/
        final RecyclerListDiffUtil diffCallback = new RecyclerListDiffUtil();
        final RecyclerListAdapter adapter = new RecyclerListAdapter(diffCallback);
/*        adapter.submitList(list);*/
        recyclerViewList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewList.setAdapter(adapter);


        listAddBtn.setOnClickListener(view -> {
            List<String> list = new ArrayList<>();
            int num = (int) (Math.random()*100);
            list.add("추가된 아이템"+num);
            adapter.submitList(list);
        });

    }
}