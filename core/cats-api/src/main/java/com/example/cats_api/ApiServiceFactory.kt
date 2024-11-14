package com.example.cats_api

import com.example.cats_api.utils.CatsApiKeyInterceptor
import com.example.database.BuildConfig
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create

object ApiServiceFactory {
    fun CatsApi(): CatsApi {
        return retrofit().create()
    }

    private fun retrofit(): Retrofit {
        val json = Json { ignoreUnknownKeys = true }
        val jsonConverterFactory = json.asConverterFactory("application/json".toMediaType())

        val modifiedOkHttpClient = OkHttpClient.Builder()
                .addInterceptor(CatsApiKeyInterceptor(BuildConfig.API_KEY))
                .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(jsonConverterFactory)
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .client(modifiedOkHttpClient)
            .build()
    }
}
