package com.kova700.someonesdiary.data.api

import com.kova700.someonesdiary.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class UnsplashServiceInterceptor : Interceptor {
    override fun intercept(
        chain: Interceptor.Chain
    ): Response {
        val newRequest = chain.request()
            .addHeader(AUTHORIZATION, BuildConfig.UNSPLASH_ACCESS_KEY)
        return chain.proceed(newRequest)
    }

    private fun Request.addHeader(headerName: String, headerContent: String): Request {
        return this.newBuilder()
            .addHeader(headerName, headerContent)
            .build()
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
    }
}