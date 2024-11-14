package com.example.data.database

import com.example.cats_api.CatsApi
import com.example.cats_api.models.Order
import com.example.data.model.Cat
import com.example.data.toCats

class ServerRepository(
    private val api: CatsApi,
) {
    suspend fun search(orderParam: String, limit: Int, page: Int): Result<List<Cat>> {
        return try {
            val cats = api.search(order = Order.valueOf(orderParam), limit = limit, page = page)
                .map {
                    it.toCats()
                }
            Result.success(cats)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
