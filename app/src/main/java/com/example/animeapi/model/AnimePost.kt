package com.example.animeapi.model

import com.google.gson.annotations.SerializedName

data class AnimePost(
    @SerializedName("data")
    val data: Data
)

data class Data(
    @SerializedName("attributes")
    val attributes: Attributes
)

data class Attributes(
    @SerializedName("description")
    val description: String,
    @SerializedName("titles")
    val titles: Titles,
    @SerializedName("posterImage")
    val posterImage: PosterImage
)

data class Titles(
    @SerializedName("en")
    val en: String
)

data class PosterImage(
    @SerializedName("medium")
    val medium: String
)