package com.example.numericfacts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.numericfacts.databinding.ActivityMainBinding
import com.example.numericfacts.domain.AppDatabase
import com.example.numericfacts.domain.data.NumericInfoDbEntity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayUseLogoEnabled(true)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()

        bottomNavigationViewSelected()
    }

    private fun bottomNavigationViewSelected() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.visibility = View.GONE

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.app_bar_favorites -> {
                    navController!!.navigate(R.id.favoritesListFragment)
                    true
                }
                R.id.app_bar_history -> {
                    navController!!.navigate(R.id.historyListFragment)
                    true
                }
                R.id.app_bar_home -> {
                    navController!!.navigate(R.id.homeFragment)
                    true
                }
                else -> false
            }
        }
    }

    fun changeVisibilityBottomNavigation(visibility: Int) {
        bottomNavigationView.visibility = visibility
    }
}