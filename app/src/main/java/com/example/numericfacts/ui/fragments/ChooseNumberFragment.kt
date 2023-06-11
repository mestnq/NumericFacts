package com.example.numericfacts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentChooseNumberBinding
import com.example.numericfacts.databinding.FragmentDescriptionBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val s = "param1"
private const val s1 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChooseNumberFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChooseNumberFragment : Fragment() {

    private lateinit var binding: FragmentChooseNumberBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(s)
            param2 = it.getString(s1)
            //todo: AlertDialogBuilder and найти метод в нем который будет тормозить всю внешнюю хрень
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseNumberBinding.inflate(inflater, container, false)
        return binding.root
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChooseNumberFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChooseNumberFragment().apply {
                arguments = Bundle().apply {
                    putString(s, param1)
                    putString(s1, param2)
                }
            }
    }
}