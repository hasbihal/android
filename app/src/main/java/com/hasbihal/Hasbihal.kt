package com.hasbihal

import android.app.Application
import com.hasbihal.di.module.RetrofitModule
import com.hasbihal.di.module.UserViewModelModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber



class Hasbihal: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(
                UserViewModelModule,
                RetrofitModule))

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}