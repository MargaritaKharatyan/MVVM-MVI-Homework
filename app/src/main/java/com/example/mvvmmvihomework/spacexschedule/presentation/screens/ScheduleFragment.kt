package com.example.mvvmmvihomework.spacexschedule.presentation.screens

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentScheduleBinding.bind(view)
        init()
        getInfo()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getInfo() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.scheduleflow.collectLatest { scheduleList ->
                    adapter.submitList(scheduleList)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.currentTime.collectLatest {
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