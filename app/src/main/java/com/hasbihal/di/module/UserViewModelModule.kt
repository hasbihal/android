package com.hasbihal.di.module

import com.hasbihal.data.remote.RemoteDataSource
import com.hasbihal.data.repository.UserRepository
import com.hasbihal.main.UserViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val UserViewModelModule = module {

    single { RemoteDataSource() }

    single { UserRepository( get() ) }

    viewModel<UserViewModel>()
}