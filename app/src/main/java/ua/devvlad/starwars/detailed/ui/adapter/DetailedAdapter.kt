package ua.devvlad.starwars.detailed.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ua.devvlad.starwars.detailed.ui.adapter.viewholder.DetailedViewHolder
import ua.devvlad.starwars.search.ui.adapter.SearchEvent

class DetailedAdapter:
    ListAdapter<String, DetailedViewHolder>(DetailedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailedViewHolder {
        return DetailedViewHolder(parent)
    }

    override fun onBindViewHolder(holder: DetailedViewHolder, position: Int) {
        holder.initEntity(getItem(position))
    }
}