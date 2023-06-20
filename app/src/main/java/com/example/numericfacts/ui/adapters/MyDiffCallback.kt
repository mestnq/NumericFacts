package com.example.numericfacts.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.numericfacts.network.data.NumericInfo

class MyDiffCallback : DiffUtil.ItemCallback<NumericInfo>() {

    override fun areItemsTheSame(oldItem: NumericInfo, newItem: NumericInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NumericInfo, newItem: NumericInfo): Boolean {
        return oldItem == newItem
    }
}