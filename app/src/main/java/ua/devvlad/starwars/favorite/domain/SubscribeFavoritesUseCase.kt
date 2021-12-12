package ua.devvlad.starwars.favorite.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import javax.inject.Inject

class SubscribeFavoritesUseCase @Inject constructor(
    private val favoriteStorage: FavoriteStorage,
) {
    suspend operator fun invoke(): Flow<List<StarWarsDto>> {
        return withContext(Dispatchers.IO) {
            favoriteStorage.flow
        }
    }
}