package com.example.animeapi.api

import com.example.animeapi.model.AnimePost
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApi {
    @GET("api/edge/anime/{id}")
    suspend fun getPost(
        @Path("id") id: Int
    ): Response<AnimePost>
}