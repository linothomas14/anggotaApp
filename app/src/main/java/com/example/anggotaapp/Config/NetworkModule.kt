package com.example.anggotaapp.Config

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkModule {

    var gson = GsonBuilder()
        .setLenient()
        .create()

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("http://192.168.1.10/mentoring_kotlin/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun service(): ApiService = getRetrofit().create(ApiService::class.java)
}