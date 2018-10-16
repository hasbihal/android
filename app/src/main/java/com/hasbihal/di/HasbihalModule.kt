package com.hasbihal.di

import com.hasbihal.main.UserViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val HasbihalModule = module(definition = {
    viewModel<UserViewModel>()
})


val hasbihalAppModules = listOf(HasbihalModule)