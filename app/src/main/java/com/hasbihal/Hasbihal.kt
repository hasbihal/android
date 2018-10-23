package com.hasbihal

import android.app.Application
import com.hasbihal.di.module.hasbihalAppModules
import org.koin.android.ext.android.startKoin
import timber.log.Timber



class Hasbihal: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, hasbihalAppModules)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}