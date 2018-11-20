package com.example.elad.test.data.local;

import com.example.elad.test.constant.Constants;
import com.example.elad.test.data.remote.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static Retrofit retrofitManager;
    private RetrofitManager() {}

    private static Retrofit getRetrofitManager() {
        if(retrofitManager == null) {
            return new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitManager;
    }

    public static Api getApi() {
        return getRetrofitManager().create(Api.class);
    }
}
