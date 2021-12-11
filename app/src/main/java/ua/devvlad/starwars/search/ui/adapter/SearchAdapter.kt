package ua.devvlad.starwars.search.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ua.devvlad.starwars.search.ui.adapter.viewholder.SearchViewHolder
import ua.devvlad.starwars.search.ui.model.CharacterUIModel

class SearchAdapter(private val addCallback: (name: String) -> Unit) :
    ListAdapter<CharacterUIModel, SearchViewHolder>(SearchDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(parent)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.initEntity(getItem(position),addCallback)
    }
}