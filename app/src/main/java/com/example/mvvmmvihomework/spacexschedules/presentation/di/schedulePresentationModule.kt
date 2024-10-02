package com.example.mvvmmvihomework.spacexschedules.presentation.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mvvmmvihomework.spacexschedules.presentation.view_model.ScheduleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

@RequiresApi(Build.VERSION_CODES.O)
val presentationModule = module {
    viewModel { ScheduleViewModel(get()) }
}