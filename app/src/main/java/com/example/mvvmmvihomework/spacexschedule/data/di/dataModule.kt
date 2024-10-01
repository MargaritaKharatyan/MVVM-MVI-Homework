package com.example.mvvmmvihomework.spacexschedule.data.di

import com.example.mvvmmvihomework.spacexschedule.data.helper.SpaceXScheduleHelper
import com.example.mvvmmvihomework.spacexschedule.data.repository.SpaceXScheduleRepositoryImpl
import com.example.mvvmmvihomework.spacexschedule.domain.repository.SpaceXScheduleRepository

import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

val dataModule = module {
    singleOf(::SpaceXScheduleHelper)
    singleOf(::SpaceXScheduleRepositoryImpl) { bind<SpaceXScheduleRepository>() }
}
