package com.example.animeapi.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.animeapi.R
import com.example.animeapi.databinding.ActivityMainBinding
import com.example.animeapi.model.AnimePost
import com.example.animeapi.repository.AnimeViewModel
import com.example.animeapi.repository.AnimeViewModelFactory
import com.example.animeapi.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: AnimeViewModel
    private lateinit var binding: ActivityMainBinding
    private val anime: MutableList<AnimePost> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = AnimeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AnimeViewModel::class.java)

        var randomId: Int = (100..5000).random()
        viewModel.getPost(randomId)
        viewModel.myResponse.observe(this, {
            if (it.isSuccessful) {
                binding.titleAnime.text = it.body()!!.data.attributes.titles.en
                binding.descAnime.text = it.body()!!.data.attributes.description
                Glide.with(this)
                    .load(it.body()!!.data.attributes.posterImage.medium)
                    .into(binding.posterAnime)
            } else {
                randomId = (100..5000).random()
                viewModel.getPost(randomId)
            }
        })

        binding.button.setOnClickListener {
            randomId = (100..5000).random()
            viewModel.getPost(randomId)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.refresh_button -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}