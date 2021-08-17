package com.example.listviewandrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    List<String> list;
    public ListViewAdapter(List<String> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        Log.d("my-tag", "get count가 호출됨");
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // xml을 inflate해서 View로 만드는 과정
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item_text, viewGroup, false);

        // findViewById 하는 과정
        TextView itemText = itemView.findViewById(R.id.itemText);

        // 현 위치의 데이터를 뽑아와서 아이템뷰에 적용하는 과정
        String data = list.get(i);
        itemText.setText(data);

        return itemView;
    }
}
