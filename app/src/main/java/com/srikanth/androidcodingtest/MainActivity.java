package com.srikanth.androidcodingtest;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.srikanth.androidcodingtest.adapter.Adapter;
import com.srikanth.androidcodingtest.model.Model;
import com.srikanth.androidcodingtest.model.Row;
import com.srikanth.androidcodingtest.retrofit.ApiInterface;
import com.srikanth.androidcodingtest.retrofit.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;

    RecyclerView recyclerView;
    private ArrayList<Row> rowData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCanadaFactsResponse();
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

    /**
     * Fetch canada facts api response
     */
    private void getCanadaFactsResponse() {
        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<Model> call = apiInterface.getFacts();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NotNull Call<Model> call, @NotNull Response<Model> response) {
                Gson gson = new Gson();
                Model model = response.body();
                assert model != null;
                Log.d("RESPONSE",gson.toJson(model));
            }

            @Override
            public void onFailure(@NotNull Call<Model> call, @NotNull Throwable t) {
                t.getStackTrace();

            }
        });
    }
}
