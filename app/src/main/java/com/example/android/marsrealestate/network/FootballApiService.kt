
package com.example.android.marsrealestate.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://v3.football.api-sports.io/"
//@Headers(value = ["x-rapidapi-key: f8a078cd3021aca67ef155ad6b13e972",
//    "x-rapidapi-host : v3.football.api-sports.io"])

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//val retrofit = Retrofit.Builder()
//    .addConverterFactory(ScalarsConverterFactory.create())
//    .baseUrl(BASE_URL)
//    .build()

interface FootballApiService {
    @Headers("x-rapidapi-key:f8a078cd3021aca67ef155ad6b13e972",
    "x-rapidapi-host:v3.football.api-sports.io")
    @GET("fixtures?live=all")
    suspend fun getProperties() : FootballProperty
}

object MarsApi{
    val RETROFIT_SERVICE : FootballApiService by lazy {
        retrofit.create(FootballApiService::class.java)
    }
}








