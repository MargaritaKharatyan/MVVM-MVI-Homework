package com.example.mvvmmvihomework.spacexschedules.domain.di

import com.example.mvvmmvihomework.spacexschedules.domain.usecase.GetScheduleUseCase
import com.example.mvvmmvihomework.spacexschedules.domain.usecase.GetScheduleUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::GetScheduleUseCaseImpl) { bind<GetScheduleUseCase>() }
}