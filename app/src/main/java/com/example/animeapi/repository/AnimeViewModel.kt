package com.example.animeapi.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animeapi.model.AnimePost
import kotlinx.coroutines.launch
import retrofit2.Response

class AnimeViewModel(private val repository: Repository): ViewModel() {
    val myResponse: MutableLiveData<Response<AnimePost>> = MutableLiveData()

    fun getPost(id: Int) {
        viewModelScope.launch {
            val response = repository.getPost(id = id)
            myResponse.value = response
        }
    }
}