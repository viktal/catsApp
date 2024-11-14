package com.example.cats_api.utils

import okhttp3.Interceptor
import okhttp3.Response

internal class CatsApiKeyInterceptor(private val apiKey: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header(name = "x-api-key", value = apiKey)
            .build()
        return chain.proceed(request)
    }
}
