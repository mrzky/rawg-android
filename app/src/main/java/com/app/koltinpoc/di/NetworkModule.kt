package com.app.koltinpoc.di

import android.app.Application
import com.app.koltinpoc.api.GameApi
import com.app.koltinpoc.api.TopHeadlinesApi
import com.app.koltinpoc.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesTopHeadlinesApi(retrofit: Retrofit): GameApi {
        return retrofit.create(GameApi::class.java)
    }


}