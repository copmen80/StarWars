package ua.devvlad.starwars.search.data

import ua.devvlad.starwars.search.data.response.StarWarsResponse
import javax.inject.Inject


class StarWarsRepository @Inject constructor(
    private val starWarsService: StarWarsService,
) {
    suspend fun getAllCharacters(): StarWarsResponse {
        return starWarsService.getAllCharacters()
    }
}
