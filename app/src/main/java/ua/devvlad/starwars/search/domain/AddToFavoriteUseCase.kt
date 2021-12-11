package ua.devvlad.starwars.search.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.StarWarsDAO
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(
    private val starWarsDAO: StarWarsDAO,
) {
    suspend operator fun invoke(starWarsDto: StarWarsDto) {
        withContext(Dispatchers.IO){
            starWarsDAO.insert(starWarsDto)
        }
    }
}