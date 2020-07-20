package com.srikanth.androidcodingtest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.srikanth.androidcodingtest.adapter.Adapter;
import com.srikanth.androidcodingtest.model.Row;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Row> rowData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        rowData.add(new Row("Sri", "Android app developer jfhsfsflk sdkhjfjhsdjkfj kjhsdfjhhjsdf", 0));
        rowData.add(new Row("Sri", "Android app developer jfhsfsflk sdkhjfjhsdjkfj kjhsdfjhhjsdf jfhsfsflk sdkhjfjhsdjkfj kjhsdfjhhjsdf", 1));
        rowData.add(new Row("Sri", null, 2));
        rowData.add(new Row(null, "Android app developer", 3));
        rowData.add(new Row("Sri", "Android app developer", 4));

        Adapter adapter = new Adapter(rowData);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
