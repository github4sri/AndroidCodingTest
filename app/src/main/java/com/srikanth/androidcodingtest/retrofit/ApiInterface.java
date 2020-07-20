package com.srikanth.androidcodingtest.retrofit;

import com.srikanth.androidcodingtest.model.Model;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This is an interface that contains methods that represent  API Call
 */
public interface ApiInterface {

    /**
     * end point is facts.json
     * @return
     */

    @GET("facts.json")
    Call<Model> getFacts();
}
