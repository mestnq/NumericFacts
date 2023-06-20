package com.example.numericfacts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numericfacts.databinding.FragmentFavoritesListBinding
import com.example.numericfacts.ui.adapters.FavoritesListAdapter

class FavoritesListFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesListBinding
    private val favoritesListAdapter = FavoritesListAdapter() //todo

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesListBinding.inflate(inflater, container, false)
        return binding.root
    }
}