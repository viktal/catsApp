package com.example.cats_api

import androidx.annotation.IntRange
import com.example.cats_api.models.Order
import com.example.cats_api.models.ResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query


// API documentation https://developers.thecatapi.com

interface CatsApi {
    @GET("v1/images/search")
    suspend fun search(
        @Query("limit") @IntRange(from = 1, to = 100) limit: Int = 10,
        @Query("page") page: Int = 0,
        @Query("order") order: Order? = null,
        @Query("has_breeds") hasBreeds: Boolean? = true,
        @Query("breed_ids") breedIds: String? = null,
        @Query("sub_id") subId: String? = null,
    ) : List<ResponseDTO>
}
