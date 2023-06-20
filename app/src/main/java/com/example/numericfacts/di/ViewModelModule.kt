package com.example.numericfacts.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.numericfacts.ui.viewmodels.FavoritesViewModel
import com.example.numericfacts.ui.viewmodels.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FavoritesViewModel::class)
    abstract fun favoritesViewModel(viewModel: FavoritesViewModel): ViewModel
}