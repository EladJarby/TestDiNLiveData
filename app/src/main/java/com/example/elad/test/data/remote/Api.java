package com.example.elad.test.data.remote;

import com.example.elad.test.data.model.ContactsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/contacts")
    Call<ContactsList> getJson();
}
