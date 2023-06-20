package com.example.numericfacts.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.numericfacts.databinding.CardFavoritesBinding
import com.example.numericfacts.network.data.NumericInfo
import com.example.numericfacts.ui.model.Item

class FavoritesAdapter : ListAdapter<Item, RecyclerView.ViewHolder>(MyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
                val binding = CardFavoritesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                DefaultCardHolder(binding)
            }
            else -> throw IllegalStateException("Unknown view type $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Item -> 0
            else -> Int.MAX_VALUE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            0 -> (holder as DefaultCardHolder).bind(getItem(position) as Item)
//            R.layout.big_card_without_bag -> (holder as DefaultCardHolder).bind(getItem(position) as Card.DefaultCard) //todo
            else -> throw IllegalStateException("Unknown item view type ${holder.itemViewType}")
        }
    }

    inner class DefaultCardHolder(private val binding: CardFavoritesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(defaultInfo: Item) = with(binding) {
            factList.text = defaultInfo.text
            intAndType.text = "number: ${defaultInfo.number}, type: ${defaultInfo.type}"
        }
    }

    class MyDiffCallback : DiffUtil.ItemCallback<Item>() {

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}