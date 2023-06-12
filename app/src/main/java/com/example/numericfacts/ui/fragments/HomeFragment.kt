package com.example.numericfacts.ui.fragments

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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

        //region Helpers
        binding.helper1.setOnClickListener {
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDescriptionFragment(R.string.description_math)
            )
        }
        binding.helper2.setOnClickListener {
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDescriptionFragment(R.string.description_date)
            )
        }
        binding.helper3.setOnClickListener {
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDescriptionFragment(R.string.description_trivia)
            )
        }
        //endregion

        //region Bottom toolbar

        /*binding.bar.
            .setOnClickListener {
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDescriptionFragment(getString(R.string.description_math))
            )
        }*/

        //endregion

        //region Rectangles
        val actionToNum = HomeFragmentDirections.actionHomeFragmentToChooseNumberFragment()
        //math
        binding.rectangle1.setOnClickListener {
            view.findNavController().navigate(actionToNum)
        }
        val actionToDate = HomeFragmentDirections.actionHomeFragmentToChooseDateFragment()
        //date
        binding.rectangle2.setOnClickListener {
            view.findNavController().navigate(actionToDate)
        }
        //trivia
        binding.rectangle3.setOnClickListener {
            view.findNavController().navigate(actionToDate)
        }
        //random
        binding.rectangle4.setOnClickListener {
            val action = if (Math.random() % 2 === 0.0) {
                actionToNum
            } else {
                actionToDate
            }
            view.findNavController().navigate(action)
        }
        //endregion
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