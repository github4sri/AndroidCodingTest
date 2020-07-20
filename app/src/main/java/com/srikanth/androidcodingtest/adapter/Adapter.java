package com.srikanth.androidcodingtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.srikanth.androidcodingtest.R;
import com.srikanth.androidcodingtest.model.Row;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    private ArrayList<Row> rowData;
    private Context context;

    public Adapter(ArrayList<Row> rowData, Context context) {
        this.rowData = rowData;
        this.context = context;
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
        Glide.with(context)
                .load(row.getImageHref())
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.ivImage);
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
