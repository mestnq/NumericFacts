package com.example.numericfacts.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import com.example.numericfacts.databinding.ChooseDateCardViewBinding

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
            val day = binding.dayTextInputEditText.text
            val month = binding.monthTextInputEditText.text

            if (day != null && month != null) {
                dismiss()

                val action = ChooseDateDialogDirections.actionChooseDateDialogToResultFragment()
                view.findNavController().navigate(action) //todo
            }
        }

        binding.closeDateCardView.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val TAG = "ChooseDateDialog"
    }
}