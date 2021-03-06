package ua.devvlad.starwars.favorite.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import ua.devvlad.starwars.search.ui.model.CharacterUIModel

internal class FavoriteDiffCallback : DiffUtil.ItemCallback<CharacterUIModel>() {
    override fun areItemsTheSame(oldItem: CharacterUIModel, newItem: CharacterUIModel): Boolean {
        return oldItem::class.java.simpleName == newItem::class.java.simpleName
    }

    override fun areContentsTheSame(oldItem: CharacterUIModel, newItem: CharacterUIModel): Boolean {
        return oldItem == newItem
    }
}