package com.kova700.someonesdiary.data.source.unsplash

import com.kova700.someonesdiary.data.api.UnsplashService
import com.kova700.someonesdiary.data.source.unsplash.remote.Photo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(
    private val unsplashService: UnsplashService,
) : UnsplashRepository {

    override fun getPhotoList(query: String, page: Int): Flow<List<Photo>> =
        flow {
            unsplashService.getPhoto(
                query = query,
                page = page
            )
        }

}