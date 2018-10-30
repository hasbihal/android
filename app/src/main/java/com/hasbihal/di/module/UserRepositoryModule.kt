package com.hasbihal.di.module

import com.hasbihal.data.IDataSource
import org.koin.dsl.module.module

val UserRepositoryModule = module {

    factory { IDataSource() }
}