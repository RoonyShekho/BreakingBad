package com.example.breakingbad.di

import com.example.breakingbad.data.remote.BreakingBadApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


const val BASE_URL = "https://www.breakingbadapi.com"


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    private val httpLoggingInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }


    private val json = Json {
        ignoreUnknownKeys = true
    }


    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttp: OkHttpClient): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            .build()
    }



    @Singleton
    @Provides
    fun provideWeatherApi(
        retrofit: Retrofit
    ): BreakingBadApi{
        return retrofit.create(BreakingBadApi::class.java)
    }

}