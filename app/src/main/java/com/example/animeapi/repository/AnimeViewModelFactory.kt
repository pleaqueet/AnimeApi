package com.example.animeapi.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AnimeViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AnimeViewModel(repository) as T
    }
}