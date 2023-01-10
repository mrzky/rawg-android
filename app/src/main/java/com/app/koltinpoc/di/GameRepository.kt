package com.app.koltinpoc.di

import com.app.koltinpoc.api.GameApi
import com.app.koltinpoc.model.GameResponse
import retrofit2.Response
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val gameApi: GameApi
) {

    suspend fun getVideoGames(page: Int, page_size: Int, apiKey: String): Response<GameResponse> {
        return gameApi.getVideoGames(page, page_size, apiKey)
    }

}