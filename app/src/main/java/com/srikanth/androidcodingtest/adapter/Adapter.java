package com.srikanth.androidcodingtest.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
