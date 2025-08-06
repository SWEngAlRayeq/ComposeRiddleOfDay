package app.riddle_of_day.di

import app.riddle_of_day.data.api.RiddleApi
import app.riddle_of_day.data.repo_impl.RiddleRepositoryImpl
import app.riddle_of_day.domain.repo.RiddleRepository
import app.riddle_of_day.domain.usecase.GetRiddleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    @Provides
    fun provideRiddleApi(okHttpClient: OkHttpClient): RiddleApi =
        Retrofit.Builder()
            .baseUrl("https://riddles-api.vercel.app/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RiddleApi::class.java)

    @Provides
    fun provideRiddleRepository(api: RiddleApi): RiddleRepository =
        RiddleRepositoryImpl(api)

    @Provides
    fun provideGetRiddleUseCase(repo: RiddleRepository): GetRiddleUseCase =
        GetRiddleUseCase(repo)

}