package com.example.numericfacts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.numericfacts.MainActivity
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentHomeBinding
import com.example.numericfacts.ui.dialogs.ChooseDateDialog
import com.example.numericfacts.ui.dialogs.ChooseNumberDialog
import com.example.numericfacts.ui.dialogs.DescriptionDialog
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val SDF = SimpleDateFormat("E, dd/M/yyyy")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentDate = SDF.format(Date())
        binding.currentDay.text = currentDate

        (activity as MainActivity?)?.changeVisibilityBottomNavigation(View.VISIBLE)

        //region Helpers
        binding.helper1.setOnClickListener {
            showDescriptionDialog(R.string.description_math)
        }
        binding.helper2.setOnClickListener {
            showDescriptionDialog(R.string.description_date)
        }
        binding.helper3.setOnClickListener {
            showDescriptionDialog(R.string.description_trivia)
        }
        //endregion

        //region Rectangles
        //math
        binding.rectangle1.setOnClickListener {
            showChooseNumberDialog(R.string.math_type)
        }
        //date
        binding.rectangle2.setOnClickListener {
            ChooseDateDialog().show(childFragmentManager, ChooseDateDialog.TAG)
        }
        //trivia
        binding.rectangle3.setOnClickListener {
            showChooseNumberDialog(R.string.trivia_type)
        }
        //random
        binding.rectangle4.setOnClickListener {//todo: created really random
            val type = if ((0..10).random() > 5) {
                R.string.trivia_type
            } else {
                R.string.math_type
            }
            showChooseNumberDialog(type)
        }
        //endregion
    }

    private fun showDescriptionDialog(res: Int) {
        val dd = DescriptionDialog().newInstance(res)
        dd.show(childFragmentManager, DescriptionDialog.TAG)
    }

    private fun showChooseNumberDialog(res: Int) {
        val dd = ChooseNumberDialog().newInstance(res)
        dd.show(childFragmentManager, ChooseNumberDialog.TAG)
    }
}