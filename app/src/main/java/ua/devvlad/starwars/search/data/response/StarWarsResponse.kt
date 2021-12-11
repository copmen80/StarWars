package ua.devvlad.starwars.search.data.response

import com.google.gson.annotations.SerializedName


data class StarWarsResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val people: List<People>,
)