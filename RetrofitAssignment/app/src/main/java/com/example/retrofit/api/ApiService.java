package com.example.retrofit.api;

import com.example.retrofit.data.ArticleData;
import com.example.retrofit.data.ArticlesData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/api/articles")
    Call<ArticlesData> getArticle();
}
