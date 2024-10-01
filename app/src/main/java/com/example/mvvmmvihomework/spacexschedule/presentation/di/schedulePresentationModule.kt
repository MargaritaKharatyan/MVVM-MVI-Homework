package com.example.mvvmmvihomework.spacexschedule.presentation.di

import com.example.mvvmmvihomework.spacexschedule.presentation.view_model.ScheduleViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModel{ScheduleViewModel(get())}
//    viewModelOf(::ScheduleViewModel)
}