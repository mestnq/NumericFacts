package com.example.numericfacts.di

import com.example.numericfacts.MainActivity
import com.example.numericfacts.ui.adapters.FavoritesAdapter
import com.example.numericfacts.ui.fragments.*
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: IntroFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: ResultFragment)
    fun inject(fragment: HistoryListFragment)
    fun inject(fragment: FavoritesListFragment)
    fun inject(adapter: FavoritesAdapter)

}