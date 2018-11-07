package com.hasbihal.di.module

import com.hasbihal.BASE_URL
import com.hasbihal.data.IDataSource
import com.hasbihal.data.remote.RemoteDataSource
import com.hasbihal.data.repository.UserRepository
import com.hasbihal.main.UserViewModel
import com.hasbihal.network.MessageApi
import com.hasbihal.network.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val RetrofitModule: Module = module {

    // Create Retrofit instance
    single { createOkHttpClient() }
    single { createWebService( get() ) }

    // Create end-points
    single{ provideUserApi(get()) }
    single{ provideMessagesApi(get()) }
}

val UserViewModelModule : Module = module {

    single<IDataSource> { RemoteDataSource() }

    single { UserRepository( get() ) }

    viewModel<UserViewModel>()
}

fun provideUserApi(retrofit: Retrofit): UserApi {
    return retrofit.create(UserApi::class.java)
}
fun provideMessagesApi(retrofit: Retrofit): MessageApi {
    return retrofit.create(MessageApi::class.java)
}

private fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
            .connectTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
}

private fun createWebService(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}


