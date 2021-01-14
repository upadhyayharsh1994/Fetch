package com.example.harsh.fetch.network;

import com.example.harsh.fetch.model.itemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("hiring.json")
    Call<List<itemModel>> getJson();
}
