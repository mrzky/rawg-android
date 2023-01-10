package com.app.koltinpoc.api

import com.app.koltinpoc.model.GameResponse
import com.app.koltinpoc.model.NewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET("api/games")
    suspend fun getVideoGames(
        @Query("page") page: Int,
        @Query("page_size") page_size: Int,
        @Query("key") apiKey: String,
    ): Response<GameResponse>
}