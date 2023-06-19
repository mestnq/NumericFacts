package com.example.numericfacts.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.numericfacts.R
import com.example.numericfacts.databinding.ChooseDateCardViewBinding
import com.example.numericfacts.ui.fragments.ResultFragment

class ChooseDateDialog : DialogFragment() {
    private lateinit var binding: ChooseDateCardViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ChooseDateCardViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chooseDateCardView.setOnClickListener {
            val day = binding.dayTextInputEditText.text.toString().toInt() //todo: validate
            val month = binding.monthTextInputEditText.text.toString().toInt()

            dismiss()

            findNavController().navigate(R.id.action_homeFragment_to_resultFragment2)
        }
    }

    companion object {
        const val TAG = "ChooseDateDialog"
    }
}