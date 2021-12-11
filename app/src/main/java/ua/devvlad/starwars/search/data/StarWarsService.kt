package ua.devvlad.starwars.search.data

import retrofit2.http.GET
import ua.devvlad.starwars.search.data.response.StarWarsResponse

interface StarWarsService {
    @GET("people/")
    suspend fun getAllCharacters(): StarWarsResponse
}