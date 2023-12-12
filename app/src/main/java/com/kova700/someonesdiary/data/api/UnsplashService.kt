package com.kova700.someonesdiary.data.api

import com.kova700.someonesdiary.data.source.unsplash.remote.PhotoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashService {

    @GET("/search/photos")
    suspend fun getPhoto(
        @Query("query") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = GET_UNSPLASH_PHOTO_API_PAGING_SIZE
    ): PhotoResponse

    companion object {
        const val GET_UNSPLASH_PHOTO_API_PAGING_SIZE = 30
    }
}