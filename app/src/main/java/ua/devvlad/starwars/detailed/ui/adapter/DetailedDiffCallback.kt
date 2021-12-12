package ua.devvlad.starwars.detailed.ui.adapter

import androidx.recyclerview.widget.DiffUtil

internal class DetailedDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem::class.java.simpleName == newItem::class.java.simpleName
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}