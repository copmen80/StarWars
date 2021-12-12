package ua.devvlad.starwars.detailed.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.devvlad.starwars.R
import ua.devvlad.starwars.databinding.DetailedCharacterItemBinding

class DetailedViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.detailed_character_item, parent, false)
) {
    private val binding = DetailedCharacterItemBinding.bind(itemView)

    fun initEntity(value: String) {
        with(binding) {
            itemOfDetailedList.text = value
        }
    }
}