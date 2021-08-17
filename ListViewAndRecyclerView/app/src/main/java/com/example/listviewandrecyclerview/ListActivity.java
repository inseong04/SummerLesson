package com.example.listviewandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    Button addBtn;

    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);

        list.clear();
        list.add("1 - 첫번째 기본 아이템");
        list.add("2 - 두번째 기본 아이템");
        list.add("3 - 세번쨰 기본 아이템");

        ListViewAdapter adapter = new ListViewAdapter(list);

        listView.setAdapter(adapter);

        addBtn.setOnClickListener(v -> {
            list.add("추가된 아이템");
            adapter.notifyDataSetChanged();
        });
    }
}