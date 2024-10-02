package com.example.mvvmmvihomework.spacexschedule.presentation.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvmmvihomework.spacexschedule.presentation.view_model.ScheduleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.O)
val presentationModule = module {
    viewModel { ScheduleViewModel(get()) }
}