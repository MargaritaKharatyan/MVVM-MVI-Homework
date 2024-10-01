package com.example.mvvmmvihomework.spacexschedule.domain.di

import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetCurrentTimeUseCase
import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetCurrentTimeUseCaseImpl
import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetScheduleUseCase
import com.example.mvvmmvihomework.spacexschedule.domain.usecase.GetScheduleUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetScheduleUseCaseImpl) { bind<GetScheduleUseCase>() }
    factoryOf(::GetCurrentTimeUseCaseImpl) { bind<GetCurrentTimeUseCase>() }
}