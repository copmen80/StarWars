package ua.devvlad.starwars.search.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.devvlad.starwars.R
import ua.devvlad.starwars.databinding.SearchScreenItemBinding
import ua.devvlad.starwars.search.ui.adapter.AddToFavorite
import ua.devvlad.starwars.search.ui.adapter.OpenDetailed
import ua.devvlad.starwars.search.ui.adapter.SearchEvent
import ua.devvlad.starwars.search.ui.model.CharacterUIModel

class SearchViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.search_screen_item, parent, false)
) {
    private val binding = SearchScreenItemBinding.bind(itemView)

    fun initEntity(uiModel: CharacterUIModel, callback: (event: SearchEvent) -> Unit) {
        with(binding) {
            tvNameOfCharacter.text = uiModel.name
            bToFav.setOnClickListener {
                callback(AddToFavorite(uiModel.name))
            }
            itemView.setOnClickListener {
                callback(OpenDetailed(uiModel.starWarsDto))
            }
        }
    }
}