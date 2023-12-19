package com.kova700.someonesdiary.di

import com.kova700.someonesdiary.data.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import com.kova700.someonesdiary.di.RetrofitModule.UnsplashRetrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideUnsplashService(@UnsplashRetrofit retrofit: Retrofit): UnsplashService =
        retrofit.create(UnsplashService::class.java)
}