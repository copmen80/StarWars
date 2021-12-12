package ua.devvlad.starwars.detailed.domain

import ua.devvlad.starwars.favorite.domain.FavoriteStorage
import javax.inject.Inject

class IsInFavoriteUseCase @Inject constructor(
    private val favoriteStorage: FavoriteStorage
) {
    suspend operator fun invoke(name: String): Boolean {
        return favoriteStorage.contained(name)
    }
}