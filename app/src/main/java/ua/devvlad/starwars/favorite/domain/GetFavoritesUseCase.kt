package ua.devvlad.starwars.favorite.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.StarWarsDAO
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val starWarsDAO: StarWarsDAO,
) {
    suspend operator fun invoke(): List<StarWarsDto> {
        return withContext(Dispatchers.IO) {
            starWarsDAO.getCharacters()
        }
    }
}