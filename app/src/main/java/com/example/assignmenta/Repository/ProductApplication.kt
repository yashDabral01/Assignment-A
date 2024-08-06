package com.example.assignmenta.Repository

import android.app.Application
import com.example.assignmenta.API.RetrofitHelper
import com.example.assignmenta.API.productService

class ProductApplication : Application(){
    lateinit var productRespository: ProductRespository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val productService = RetrofitHelper.getInstance().create(productService::class.java)
        productRespository = ProductRespository(productService)
    }
}