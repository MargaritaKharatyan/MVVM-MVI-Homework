package com.example.mvvmmvihomework.spacexschedules.data.di

import com.example.mvvmmvihomework.spacexschedules.data.helper.SpaceXSchedulesHelper
import com.example.mvvmmvihomework.spacexschedules.data.repository.SpaceXSchedulesRepositoryImpl
import com.example.mvvmmvihomework.spacexschedules.domain.repository.SpaceXSchedulesRepository
import org.koin.dsl.module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf

val dataModule = module {
    singleOf(::SpaceXSchedulesHelper)
    singleOf(::SpaceXSchedulesRepositoryImpl) { bind<SpaceXSchedulesRepository>() }
}
