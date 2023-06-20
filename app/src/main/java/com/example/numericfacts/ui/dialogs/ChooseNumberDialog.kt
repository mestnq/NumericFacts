package com.example.numericfacts.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.numericfacts.R
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typeStringId = arguments?.getInt("res")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = ChooseNumberCardViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textDescriptionType.text = getString(typeStringId)

        binding.chooseNumberCardView.setOnClickListener {
            val textNew = binding.numberTextInputEditText.text

            try {
                val number = binding.numberTextInputEditText.text.toString().toInt()

                dismiss()

                val bundle = Bundle()
                bundle.apply {
                    putString("type", getString(typeStringId))
                }
                bundle.apply {
                    putInt("day_or_number", number)
                }

                findNavController().navigate(R.id.action_homeFragment_to_resultFragment2, bundle)

            } catch (ex: Exception) {
                //nothing?
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