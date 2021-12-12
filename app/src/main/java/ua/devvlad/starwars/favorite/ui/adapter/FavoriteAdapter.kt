package ua.devvlad.starwars.favorite.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.favorite.ui.adapter.viewholder.FavoriteViewHolder
import ua.devvlad.starwars.search.ui.model.CharacterUIModel
import ua.devvlad.starwars.search.ui.model.DetailedCharacterUIModel

sealed class FavoriteEvent
data class RemoveFromFavorite(val name: String) : FavoriteEvent()
data class OpenDetailed(val starWarsDto: StarWarsDto) : FavoriteEvent()

class FavoriteAdapter(private val callback: (event: FavoriteEvent) -> Unit) :
    ListAdapter<CharacterUIModel, FavoriteViewHolder>(FavoriteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(parent)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.initEntity(getItem(position), callback)
    }
}