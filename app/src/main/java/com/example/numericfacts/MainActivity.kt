package com.example.numericfacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.numericfacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //todo: убрать задние переходы на страницы.
        supportActionBar?.setDisplayUseLogoEnabled(true)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.findNavController()
    }
}