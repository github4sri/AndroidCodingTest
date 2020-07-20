package com.srikanth.androidcodingtest;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.srikanth.androidcodingtest.adapter.AboutCanadaAdapter;
import com.srikanth.androidcodingtest.model.Model;
import com.srikanth.androidcodingtest.model.Row;
import com.srikanth.androidcodingtest.retrofit.ApiInterface;
import com.srikanth.androidcodingtest.retrofit.RetrofitClient;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutCanadaActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout mSwipeRefreshLayout;
    ApiInterface apiInterface;
    RecyclerView recyclerView;
    AboutCanadaAdapter aboutCanadaAdapter;
    private ArrayList<Row> rowData = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadRecyclerViewDataWithSwipeRefresh();
    }

    //Handle data with swipe to refresh
    private void loadRecyclerViewDataWithSwipeRefresh() {
        // SwipeRefreshLayout
        mSwipeRefreshLayout = findViewById(R.id.swipeContainer);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                // Fetching data from server
                getCanadaFactsResponse();
            }
        });
    }

    /**
     * Fetch canada facts api response
     */
    private void getCanadaFactsResponse() {
        // Showing refresh animation before making http call
        mSwipeRefreshLayout.setRefreshing(true);

        apiInterface = RetrofitClient.getRetrofitInstance().create(ApiInterface.class);

        Call<Model> call = apiInterface.getFacts();
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(@NotNull Call<Model> call, @NotNull Response<Model> response) {
                Model model = response.body();
                assert model != null;
                List<Row> factsData = model.getRows();
                setRecyclerViewData((ArrayList<Row>) factsData);
                ActionBar actionBar = getSupportActionBar();
                assert actionBar != null;
                actionBar.setTitle(model.getTitle());
            }

            @Override
            public void onFailure(@NotNull Call<Model> call, @NotNull Throwable t) {
                // Stopping swipe refresh
                mSwipeRefreshLayout.setRefreshing(false);

            }
        });
    }

    //Bind api response to Recycler view
    private void setRecyclerViewData(ArrayList<Row> factsList) {
        recyclerView = findViewById(R.id.recyclerview);
        AboutCanadaAdapter aboutCanadaAdapter = new AboutCanadaAdapter(factsList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(aboutCanadaAdapter);
        aboutCanadaAdapter.notifyDataSetChanged();
        // Stopping swipe refresh
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        getCanadaFactsResponse();
    }
}
