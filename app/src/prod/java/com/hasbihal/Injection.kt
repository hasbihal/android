package com.hasbihal

import com.hasbihal.data.repository.UserRepository
import com.hasbihal.main.UserViewModel
import com.hasbihal.network.MessageApi
import com.hasbihal.network.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule: Module = module {
    viewModel { UserViewModel(get()) }
}

val repositoryModule: Module = module {
    single { UserRepository(get()) }
}

val networkModule: Module = module {
    single { userApi }
    single { messageApi }
}

private val retrofit: Retrofit = createWebService(createOkHttpClient(BuildConfig.DEBUG))

private val userApi: UserApi = retrofit.create(UserApi::class.java)
private val messageApi: MessageApi = retrofit.create(MessageApi::class.java)


private fun createOkHttpClient(debug: Boolean): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    val clientBuilder = OkHttpClient.Builder()
    if (debug) {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(httpLoggingInterceptor)
    }
    clientBuilder.connectTimeout(60L, TimeUnit.SECONDS)
                 .writeTimeout(60L, TimeUnit.SECONDS)

    return clientBuilder.build()
}

private fun createWebService(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}


