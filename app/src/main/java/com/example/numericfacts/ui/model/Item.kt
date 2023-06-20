package com.example.numericfacts.ui.model

import com.example.numericfacts.domain.data.NumericInfo
import java.io.Serializable

data class Item(
    val id: Long,
    val text: String,
    val type: String,
    val number: Int,
    val viewType: Int,
) : Serializable

class Items: ArrayList<Item>(), Serializable

fun NumericInfo.toItem(): Item
        = Item(this.id, this.text, this.type, this.number, 0)

//        = this.type?.let { this.text?.let { it1 -> Item(this.id, it1, it, 0) } }!!

//fun Items.toItems(): List<Item>
//        = this.map { Item(null, "null", it, 0) }