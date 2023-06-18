package com.example.numericfacts.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
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
            val day = binding.dayTextInputEditText.text.toString().toInt() //todo: oh my God
            val month = binding.monthTextInputEditText.text.toString().toInt() //todo: oh my God

            if (day != null && month != null) {
                dismiss()

                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.add(R.id.fragment_container, ResultFragment.newInstance("date", month, day))
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit()
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