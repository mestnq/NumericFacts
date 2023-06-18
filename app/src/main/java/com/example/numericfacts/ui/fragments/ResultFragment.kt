package com.example.numericfacts.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentResultBinding
import com.example.numericfacts.domain.data.NumericInfo
import com.example.numericfacts.network.LoadingResult
import com.example.numericfacts.ui.viewmodels.MainViewModel

private const val TYPE = "type"
private const val NUMBER = "number" // or day
private const val MONTH = "month"

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    private lateinit var _type: String
    private var _number: Int = 0
    private var _month: Int = 0
    private val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)

        init()
        viewModel.init(_type, _number, _month)

        return binding.root
    }

    private fun init() {
        val observer = Observer<LoadingResult<NumericInfo>?> { newValue ->
            when (newValue) {
                is LoadingResult.Success -> {
                    binding.textViewFact.text = newValue.value?.text
                    changeVisibiliteElements(View.VISIBLE)
                }
                is LoadingResult.Failure -> {
                    binding.textViewFact.text = newValue.message
                    changeVisibiliteElements(View.GONE)
                }
                else -> {
                    binding.textViewFact.text = getString(R.string.error_connection)
                    changeVisibiliteElements(View.GONE)
                }
            }

        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    private fun changeVisibiliteElements(visible: Int) {
        binding.addToFavorites.visibility = visible
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chosenDate.text = _number.toString() //todo: continue
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            _type = it.getString(TYPE)!!
            _number = it.getInt(NUMBER)
            _month= it.getInt(MONTH)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(type: String, _dayOrNumber: Int, _month: Int?) = //todo: перепроверить где месяц а где день
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(TYPE, type)
                    putInt(NUMBER, _dayOrNumber)
                    if (_month != null){
                        putInt(MONTH, _month)
                    }
                }
            }
    }
}