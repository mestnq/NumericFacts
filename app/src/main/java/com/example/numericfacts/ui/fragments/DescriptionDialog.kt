package com.example.numericfacts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.fragment.app.DialogFragment
import com.example.numericfacts.R

class DescriptionDialog : DialogFragment() {
    private var descriptionStringId = 0

    fun newInstance(res: Int): DescriptionDialog {
        val frag = DescriptionDialog()
        val args = Bundle()
        args.putInt("res", res)
        frag.arguments = args
        return frag
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        descriptionStringId = arguments?.getInt("res")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater.inflate(R.layout.description_card_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = view.findViewById<TextView>(R.id.text_description)
        val coloredText = HtmlCompat.fromHtml(getString(descriptionStringId), HtmlCompat.FROM_HTML_MODE_LEGACY)
        textView.text = coloredText

        val button = view.findViewById<Button>(R.id.ok)
        button.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val TAG = "DialogDescription"
    }
}