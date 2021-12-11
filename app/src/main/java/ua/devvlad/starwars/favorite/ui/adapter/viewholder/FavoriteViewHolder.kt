package ua.devvlad.starwars.favorite.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.devvlad.starwars.R
import ua.devvlad.starwars.databinding.FavoriteCharactersItemBinding
import ua.devvlad.starwars.search.ui.model.CharacterUIModel

class FavoriteViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.favorite_characters_item, parent, false)
) {

    private val binding = FavoriteCharactersItemBinding.bind(itemView)

    fun initEntity(uiModel: CharacterUIModel, deleteCallback: (name: String) -> Unit) {
        with(binding) {
            tvNameOfCharacter.text = uiModel.name
            bRemove.setOnClickListener {
                deleteCallback(uiModel.name)
            }
        }
    }
}