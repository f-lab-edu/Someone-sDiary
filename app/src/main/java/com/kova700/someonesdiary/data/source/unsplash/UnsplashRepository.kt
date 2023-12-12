package com.kova700.someonesdiary.data.source.unsplash

import com.kova700.someonesdiary.data.source.unsplash.remote.Photo
import kotlinx.coroutines.flow.Flow

interface UnsplashRepository {

    fun getPhotoList(
        query: String,
        page: Int = 1,
    ): Flow<List<Photo>>
}