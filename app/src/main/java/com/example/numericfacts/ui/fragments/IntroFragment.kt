package com.example.numericfacts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.numericfacts.databinding.FragmentIntroBinding
import java.text.SimpleDateFormat
import java.util.*

class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding
    private val SDF = SimpleDateFormat("EEEE, d MMMM y")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentDate = SDF.format(Date())
        binding.date.text = currentDate

        binding.start.setOnClickListener {
            val action = IntroFragmentDirections.actionIntroFragmentToHomeFragment()
            view.findNavController().navigate(action)
        }
    }
}