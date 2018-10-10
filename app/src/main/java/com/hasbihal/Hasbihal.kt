package com.hasbihal

import android.app.Application
import com.hasbihal.di.hasbihalAppModules
import org.koin.android.ext.android.startKoin

class Hasbihal: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, hasbihalAppModules)
    }
}