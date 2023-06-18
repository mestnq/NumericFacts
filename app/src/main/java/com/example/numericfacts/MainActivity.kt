package com.example.numericfacts

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.numericfacts.databinding.ActivityMainBinding
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

    fun showBottomNavigation() {
        bottomNavigationView.visibility = View.VISIBLE
    }
}