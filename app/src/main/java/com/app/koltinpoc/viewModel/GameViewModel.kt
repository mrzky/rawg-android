package com.app.koltinpoc.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.koltinpoc.di.GameRepository
import com.app.koltinpoc.model.GameResponse
import com.app.koltinpoc.utils.Constants.API_KEY
import com.app.koltinpoc.utils.DataHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
 class GameViewModel @Inject constructor(private val gameRepository: GameRepository) : ViewModel() {

    private val _games = MutableLiveData<DataHandler<GameResponse>>()
    val games: LiveData<DataHandler<GameResponse>> = _games

    fun getVideoGames(page: Int, page_size: Int) {
        _games.postValue(DataHandler.LOADING())
        viewModelScope.launch {
            val response = gameRepository.getVideoGames(page, page_size, API_KEY)
            _games.postValue(handleResponse(response))
        }
    }

    private fun handleResponse(response: Response<GameResponse>): DataHandler<GameResponse> {
        if (response.isSuccessful) {
            response.body()?.let { it ->
                return DataHandler.SUCCESS(it)
            }
        }
        return DataHandler.ERROR(message = response.errorBody().toString())
    }
}