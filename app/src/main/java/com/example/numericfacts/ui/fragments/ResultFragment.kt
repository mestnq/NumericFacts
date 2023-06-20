package com.example.numericfacts.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.numericfacts.R
import com.example.numericfacts.databinding.FragmentResultBinding
import com.example.numericfacts.network.data.NumericInfo
import com.example.numericfacts.network.LoadingResult
import com.example.numericfacts.ui.viewmodels.MainViewModel
import xyz.teamgravity.checkinternet.CheckInternet

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

        _type = requireArguments().getString("type")!!
        _number = requireArguments().getInt("day_or_number")
        _month = requireArguments().getInt("month")

        network()

        return binding.root
    }

   private fun network() {
        CheckInternet().check { connected ->
            if (connected) {
                init()
                viewModel.init(_type, _number, _month)
            } else {
                // there is no internet
                changeVisibilityElements(false);
            }
        }
    }

    private fun init() {
        val observer = Observer<LoadingResult<NumericInfo>?> { newValue ->
            when (newValue) {
                is LoadingResult.Success -> {
                    binding.textViewFact.text = newValue.value?.text
                    changeVisibilityElements(false)
                }
                is LoadingResult.Failure -> {
                    binding.textViewFact.text = newValue.message
                    changeVisibilityElements(false)
                }
                else -> {
                    binding.textViewFact.text = getString(R.string.error_connection)
                    changeVisibilityElements(false)
                }
            }

        }
        viewModel.liveData.observe(viewLifecycleOwner, observer)
    }

    private fun changeVisibilityElements(show: Boolean) {
        binding.addToFavorites.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.okResult.setOnClickListener {
            view.findNavController().popBackStack()
        }

        binding.chosenDate.text = _number.toString()
    }
}