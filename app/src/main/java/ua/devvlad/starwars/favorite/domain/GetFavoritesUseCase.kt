package ua.devvlad.starwars.favorite.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import javax.inject.Inject

class GetFavoritesUseCase @Inject constructor(
    private val favoriteStorage: FavoriteStorage,
) {
    suspend operator fun invoke(): List<StarWarsDto> {
        return withContext(Dispatchers.IO) {
            favoriteStorage.get()
        }
    }
}