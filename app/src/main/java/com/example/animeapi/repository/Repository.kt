package com.example.animeapi.repository

import com.example.animeapi.api.RetrofitInstance
import com.example.animeapi.model.AnimePost
import retrofit2.Response

class Repository {
    suspend fun getPost(id: Int): Response<AnimePost> {
        return RetrofitInstance.api.getPost(id = id)
    }
}