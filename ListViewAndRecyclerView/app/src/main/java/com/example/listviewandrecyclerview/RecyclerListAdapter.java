package com.example.listviewandrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerListAdapter extends ListAdapter<String, RecyclerListAdapter.ViewHolder> {


    protected RecyclerListAdapter(@NonNull DiffUtil.ItemCallback<String> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_text, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerListAdapter.ViewHolder holder, int position) {
        holder.itemText.setText(getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.itemText);

        }
    }
}
