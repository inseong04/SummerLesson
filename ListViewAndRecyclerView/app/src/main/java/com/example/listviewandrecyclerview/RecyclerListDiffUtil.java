package com.example.listviewandrecyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class RecyclerListDiffUtil extends DiffUtil.ItemCallback<String> {

    @Override
    public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        return oldItem.equals(newItem);
    }

    @Override
    public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
        return oldItem.equals(newItem);
    }
}
