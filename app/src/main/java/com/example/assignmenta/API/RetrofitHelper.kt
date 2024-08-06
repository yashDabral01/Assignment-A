package com.example.assignmenta.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val BaseUrl : String = "https://dummyjson.com/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}