package com.srikanth.androidcodingtest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.srikanth.androidcodingtest.R;
import com.srikanth.androidcodingtest.model.Row;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    private ArrayList<Row> rowData;

    public Adapter(ArrayList<Row> rowData) {
        this.rowData = rowData;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
        Row row = rowData.get(position);
        holder.tvTitle.setText(row.getTitle());
        holder.tvDesc.setText(row.getDescription());
        //TODO need to work here
        holder.ivImage.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public int getItemCount() {
        return rowData.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage;
        TextView tvTitle, tvDesc;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_description);
        }
    }
}
