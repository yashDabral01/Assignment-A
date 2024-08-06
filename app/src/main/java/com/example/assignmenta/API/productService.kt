package com.example.assignmenta.API

import com.example.assignmenta.Models.Products
import retrofit2.Response
import retrofit2.http.GET

interface productService {
    @GET("products")
    suspend fun getAllProducts(
    ): Response<Products>
}