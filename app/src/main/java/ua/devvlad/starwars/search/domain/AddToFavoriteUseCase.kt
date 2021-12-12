package ua.devvlad.starwars.search.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.favorite.domain.FavoriteStorage
import javax.inject.Inject

class AddToFavoriteUseCase @Inject constructor(
    private val favoriteStorage: FavoriteStorage,
) {
    suspend operator fun invoke(starWarsDto: StarWarsDto) {
        withContext(Dispatchers.IO) {
            favoriteStorage.add(starWarsDto)
        }
    }
}