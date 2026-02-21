package com.takeda.rickyandmorty.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://rickandmortyapi.com/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface RickyAndMortyApiService {
    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int
    ) : RickyAndMortyData
}

object RickyAndMortyApi {
    val retrofitService: RickyAndMortyApiService by lazy {
        retrofit.create(RickyAndMortyApiService::class.java)
    }
}