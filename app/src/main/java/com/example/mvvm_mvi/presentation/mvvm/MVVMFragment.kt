package com.example.mvvm_mvi.presentation.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mvvm_mvi.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MVVMFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MVVMViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.ageLivedata.observe(viewLifecycleOwner) {
            binding.textviewAge.text = it.toString()
        }
        viewModel.nameLiveData.observe(viewLifecycleOwner) {
            binding.textviewName.text = it.toString()
        }
        viewModel.errorLivedata.observe(viewLifecycleOwner) {
            binding.textviewError.isVisible = it
            if (it) {
                binding.textviewError.text = "Age or name error"
            }
        }

        binding.buttonFirst.setOnClickListener { viewModel.getInfo() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}