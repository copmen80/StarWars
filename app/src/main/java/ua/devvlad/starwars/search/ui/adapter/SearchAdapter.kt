package ua.devvlad.starwars.search.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ua.devvlad.starwars.favorite.data.local.dto.StarWarsDto
import ua.devvlad.starwars.search.ui.adapter.viewholder.SearchViewHolder
import ua.devvlad.starwars.search.ui.model.CharacterUIModel
import ua.devvlad.starwars.search.ui.model.DetailedCharacterUIModel

sealed class SearchEvent
data class AddToFavorite(val name: String) : SearchEvent()
data class OpenDetailed(val starWarsDto: StarWarsDto) : SearchEvent()

class SearchAdapter(private val callback: (event: SearchEvent) -> Unit) :
    ListAdapter<CharacterUIModel, SearchViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.initEntity(getItem(position), callback)
    }
}