package com.example.numericfacts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.numericfacts.MainActivity
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val SDF = SimpleDateFormat("E, dd/M/yyyy")


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentDate = SDF.format(Date())
        binding.currentDay.text = currentDate

        (activity as MainActivity?)?.showBottomNavigation()

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
        binding.rectangle4.setOnClickListener {
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}