package com.hasbihal.di

import com.hasbihal.main.MainActivity
import org.koin.dsl.module.module

val HasbihalModule = module{
    factory { MainActivity() }
}

val hasbihalAppModules = listOf(HasbihalModule)