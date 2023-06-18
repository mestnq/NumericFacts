package com.example.numericfacts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentHistoryListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val uruururur = "param1"
private const val iririiriri = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryListFragment : Fragment() {
    private lateinit var binding: FragmentHistoryListBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(uruururur)
            param2 = it.getString(iririiriri)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryListBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryListFragment().apply {
                arguments = Bundle().apply {
                    putString(uruururur, param1)
                    putString(iririiriri, param2)
                }
            }
    }
}