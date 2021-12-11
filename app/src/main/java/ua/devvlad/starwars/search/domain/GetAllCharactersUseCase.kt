package ua.devvlad.starwars.search.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.data.StarWarsRepository
import ua.devvlad.starwars.search.ui.mapper.StarWarsPeopleToDtoMapper
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val starWarsRepository: StarWarsRepository,
    private val mapper: StarWarsPeopleToDtoMapper
) {
    suspend operator fun invoke(): List<StarWarsDto> {
        return withContext(Dispatchers.IO) {
            val starWarsResponse = starWarsRepository.getAllCharacters()
            starWarsResponse.people.map { mapper.map(it) }
        }
    }
}