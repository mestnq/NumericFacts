package com.example.numericfacts.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.numericfacts.R
import com.example.numericfacts.databinding.ChooseNumberCardViewBinding
import com.example.numericfacts.ui.fragments.HomeFragment
import com.example.numericfacts.ui.fragments.ResultFragment

class ChooseNumberDialog : DialogFragment() {
    private lateinit var binding: ChooseNumberCardViewBinding

    private var typeStringId = 0

    fun newInstance(res: Int): ChooseNumberDialog {
        val frag = ChooseNumberDialog()
        val args = Bundle()
        args.putInt("res", res)
        frag.arguments = args
        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeStringId = arguments?.getInt("res")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChooseNumberCardViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textDescriptionType.text = getString(typeStringId)

        binding.chooseNumberCardView.setOnClickListener {
            val number = binding.numberTextInputEditText.text.toString().toInt() //todo: validate

            dismiss()

//            findNavController().navigate(R.id.action_chooseDateDialog_to_resultFragment)


//            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
//            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
//            fragmentTransaction.add(
//                R.id.fragment_container,
//                ResultFragment.newInstance(getString(typeStringId), number, null)
//            )
//            fragmentTransaction.addToBackStack("HomeFragment");
//            fragmentTransaction.commit()
        }
    }

    companion object {
        const val TAG = "ChooseNumberDialog"
    }
}