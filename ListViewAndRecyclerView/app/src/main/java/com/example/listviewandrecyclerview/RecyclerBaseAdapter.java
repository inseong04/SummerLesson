package com.example.listviewandrecyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerBaseAdapter extends RecyclerView.Adapter<RecyclerBaseAdapter.ViewHolder> {

    List<String> list;

    public RecyclerBaseAdapter(List<String> list) {
        super();
        this.list = list;
        Log.d("my-tag", "생성자 실행됨");

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_text, parent, false);
        Log.d("my-tag", "on create view holder 실행됨");

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerBaseAdapter.ViewHolder holder, int position) {
        String data = list.get(position);
        holder.itemText.setText(data);
        Log.d("my-tag", "on bind view holder 실행됨");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.itemText);
            itemText.setOnClickListener(v -> {
                int position = getAdapterPosition();

                list.remove(position);
                notifyItemRemoved(position);
            });
        }
    }
}
