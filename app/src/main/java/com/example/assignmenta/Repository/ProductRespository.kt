package com.example.assignmenta.Repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.assignmenta.API.productService
import com.example.assignmenta.Models.Products

class ProductRespository(private val productService: productService) {
    private val allProductsLiveData = MutableLiveData<Products>()
    val allProducts: LiveData<Products>
        get() = allProductsLiveData

    suspend fun getAllProducts() {
        try {
            val result = productService.getAllProducts()
            if (result.body() != null) {
                Log.d("ProductRepository", "Response Body: ${result.body().toString()}")
                allProductsLiveData.postValue(result.body())
            } else {
                Log.e("ProductRepository", "Response Body is null")
                // Handle the case when the body is null
            }
        } catch (e: Exception) {
            Log.e("ProductRepository", "Error: ${e.message}")
            // Handle the exception case
        }
    }
}