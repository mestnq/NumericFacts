package com.example.numericfacts.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.findNavController
import com.example.numericfacts.databinding.ChooseNumberCardViewBinding

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ChooseNumberCardViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeStringId = arguments?.getInt("res")!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textDescriptionType.text = getString(typeStringId)

        binding.chooseNumberCardView.setOnClickListener {
            val number = binding.numberTextInputEditText.text

            if (number != null) {
                dismiss()

                val action = ChooseDateDialogDirections.actionChooseDateDialogToResultFragment()
                view.findNavController().navigate(action) //todo
            }
        }

        binding.closeNumberCardView.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val TAG = "ChooseNumberDialog"
    }
}