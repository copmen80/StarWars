package ua.devvlad.starwars.favorite.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ua.devvlad.starwars.favorite.ui.adapter.viewholder.FavoriteViewHolder
import ua.devvlad.starwars.search.ui.model.CharacterUIModel

class FavoriteAdapter(private val deleteCallback: (name: String) -> Unit) :
    ListAdapter<CharacterUIModel, FavoriteViewHolder>(FavoriteDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(parent)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.initEntity(getItem(position), deleteCallback)
    }
}