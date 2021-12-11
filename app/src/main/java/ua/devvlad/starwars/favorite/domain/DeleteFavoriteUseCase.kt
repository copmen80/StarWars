package ua.devvlad.starwars.favorite.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.StarWarsDAO
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import javax.inject.Inject

class DeleteFavoriteUseCase @Inject constructor(
    private val starWarsDAO: StarWarsDAO
) {
    suspend operator fun invoke(starWarsDto: StarWarsDto) {
        withContext(Dispatchers.IO) {
            starWarsDAO.delete(starWarsDto)
        }
    }
}