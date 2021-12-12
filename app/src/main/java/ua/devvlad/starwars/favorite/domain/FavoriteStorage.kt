package ua.devvlad.starwars.favorite.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ua.devvlad.starwars.favorite.data.local.StarWarsDAO
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteStorage @Inject constructor(
    private val starWarsDAO: StarWarsDAO
) {
    private val _flow = MutableStateFlow<List<StarWarsDto>>(emptyList())
    val flow = _flow.asStateFlow()

    suspend fun add(starWarsDto: StarWarsDto) {
        starWarsDAO.insert(starWarsDto)
        _flow.emit(starWarsDAO.getCharacters())
    }

    suspend fun get(): List<StarWarsDto> {
        val value = starWarsDAO.getCharacters()
        _flow.emit(value)
        return value
    }

    suspend fun remove(starWarsDto: StarWarsDto) {
        starWarsDAO.delete(starWarsDto)
        _flow.emit(starWarsDAO.getCharacters())
    }

    suspend fun contained(name: String): Boolean {
        return starWarsDAO.getCharacterByName(name) != null
    }
}