package com.example.mvvmmvihomework.spacexschedule.presentation.screens

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmmvihomework.R
import com.example.mvvmmvihomework.databinding.FragmentScheduleBinding
import com.example.mvvmmvihomework.spacexschedule.presentation.screens.adapter.ScheduleItemAdapter
import com.example.mvvmmvihomework.spacexschedule.presentation.view_model.ScheduleViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    private lateinit var binding: FragmentScheduleBinding
    private val adapter = ScheduleItemAdapter()

    private val viewModel: ScheduleViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScheduleBinding.bind(view)
        init()
        getInfo()
    }

    private fun getInfo() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.scheduleflow.collectLatest { scheduleList ->
                    adapter.submitList(scheduleList)
//                    Log.d("My logs",scheduleList.toString())
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getTime.collectLatest {
                    binding.currentTime.text = it
                }
            }
        }
    }

    private fun init() {
        binding.apply {
            scheduleItems.layoutManager = LinearLayoutManager(requireContext())
            scheduleItems.adapter = adapter
        }

    }
}