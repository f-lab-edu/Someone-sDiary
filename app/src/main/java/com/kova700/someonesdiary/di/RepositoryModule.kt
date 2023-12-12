package com.kova700.someonesdiary.di

import com.kova700.someonesdiary.data.source.unsplash.UnsplashRepository
import com.kova700.someonesdiary.data.source.unsplash.UnsplashRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindUnsplashRepository(repository: UnsplashRepositoryImpl): UnsplashRepository
}