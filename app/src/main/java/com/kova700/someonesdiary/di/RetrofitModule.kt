package com.kova700.someonesdiary.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kova700.someonesdiary.data.api.UnsplashServiceInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val UNSPLASH_BASE_URL = "https://api.unsplash.com/"
    private const val JSON_MEDIA_TYPE = "application/json"

    @Qualifier
    annotation class FirebaseClient

    @Qualifier
    annotation class UnsplashClient

    @Qualifier
    annotation class UnsplashRetrofit

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    fun provideUnsplashInterceptor(): UnsplashServiceInterceptor = UnsplashServiceInterceptor()

    @Provides
    @Singleton
    @UnsplashClient
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        unsplashServiceInterceptor: UnsplashServiceInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .addInterceptor(unsplashServiceInterceptor)
            .build()

    @Provides
    @Singleton
    @UnsplashRetrofit
    fun provideRetrofit(
        @UnsplashClient okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(UNSPLASH_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(converterFactory)
            .build()

    @Provides
    @Singleton
    fun provideKotlinxSerializationConverterFactory(): Converter.Factory =
        Json.asConverterFactory(JSON_MEDIA_TYPE.toMediaType())

}