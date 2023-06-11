package com.example.numericfacts.ui.fragments

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentDescriptionBinding
import com.example.numericfacts.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val parampampam = "param1"
private const val pumpum = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DescriptionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(parampampam)
            param2 = it.getString(pumpum)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: DescriptionFragmentArgs by navArgs()
        binding.textDescription.text = resources.getString(R.string.description, args.textDescription)
        
        binding.ok.setOnClickListener {
            view.findNavController().navigateUp()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DescriptionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DescriptionFragment().apply {
                arguments = Bundle().apply {
                    putString(parampampam, param1)
                    putString(pumpum, param2)
                }
            }
    }
}