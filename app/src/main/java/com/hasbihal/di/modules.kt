package com.hasbihal.di.module

import com.hasbihal.BASE_URL
import com.hasbihal.BuildConfig
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

val viewModelModule: Module = module {
    viewModel { PostListViewModel(usersPostsUseCase = get()) }
    viewModel { PostDetailsViewModel(userPostUseCase = get(), commentsUseCase = get()) }
}

val useCaseModule: Module = module {
    factory { UsersPostsUseCase(userRepository = get(), postRepository = get()) }
    factory { UserPostUseCase(userRepository = get(), postRepository = get()) }
    factory { CommentsUseCase(commentRepository = get()) }
}

val repositoryModule: Module = module {
    single { UserRepository(get()) }
    single { UserRepositoryImpl(userApi = get(), cache = get(USER_ENTITY_CACHE)) as UserRepository }
    single { PostRepositoryImpl(postsApi = get(), cache = get(POST_ENTITY_CACHE)) as PostRepository }
    single { CommentRepositoryImpl(commentsApi = get(), cache = get(COMMENT_ENTITY_CACHE)) as CommentRepository }
}

val networkModule: Module = module {
    single { userApi }
    single { messageApi }
}

private val retrofit: Retrofit = createWebService(createOkHttpClient(BuildConfig.DEBUG))

private val userApi: UserApi = retrofit.create(UserApi::class.java)
private val messageApi: MessageApi = retrofit.create(MessageApi::class.java)


fun provideUserApi(retrofit: Retrofit): UserApi {
    return retrofit.create(UserApi::class.java)
}
fun provideMessagesApi(retrofit: Retrofit): MessageApi {
    return retrofit.create(MessageApi::class.java)
}

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


