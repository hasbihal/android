package com.hasbihal.di.module

import com.hasbihal.data.repository.IRepository
import com.hasbihal.data.repository.UserRepository
import com.hasbihal.main.UserViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val HasbihalModule = module {

    single<IRepository> { UserRepository() }

    viewModel { UserViewModel( get() ) }

}


val hasbihalAppModules = listOf(HasbihalModule)