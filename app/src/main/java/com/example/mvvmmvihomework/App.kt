package com.example.mvvmmvihomework

import android.app.Application
import com.example.mvvmmvihomework.spacexschedule.data.di.dataModule
import com.example.mvvmmvihomework.spacexschedule.domain.di.domainModule
import com.example.mvvmmvihomework.spacexschedule.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(presentationModule, domainModule, dataModule)
        }
    }
}