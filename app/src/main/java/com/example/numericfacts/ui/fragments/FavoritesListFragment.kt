package com.example.numericfacts.ui.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.numericfacts.MainActivity
import com.example.numericfacts.databinding.FragmentFavoritesListBinding
import com.example.numericfacts.di.ViewModelFactory
import com.example.numericfacts.di.appComponent
import com.example.numericfacts.di.showLongToast
import com.example.numericfacts.ui.adapters.FavoritesAdapter
import com.example.numericfacts.ui.viewmodels.FavoritesViewModel
import javax.inject.Inject

class FavoritesListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by viewModels<FavoritesViewModel> { viewModelFactory }

    private val adapter = FavoritesAdapter()

    private lateinit var binding: FragmentFavoritesListBinding

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}