package com.hasbihal

import android.app.Application
import android.content.Context
import org.koin.android.ext.android.get
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class Hasbihal: Application() {

    companion object{
        var app: Application? = null
    }

    override fun onCreate() {
        super.onCreate()

        if (app == null){
            app = this
        }

        startKoin(this, listOf(
                viewModelModule,
                repositoryModule,
                networkModule))

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}