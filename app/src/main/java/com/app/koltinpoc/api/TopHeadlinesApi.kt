package com.app.koltinpoc.api

import com.app.koltinpoc.model.NewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApi {

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Response<NewResponse>



    @GET("api/games")
    suspend fun getVideoGames(
        @Query("page") page: String,
        @Query("page_size") page_size: String,
        @Query("key") apiKey: String,
    ): Response<NewResponse>
}