package com.example.assignmenta.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignmenta.Models.Products
import com.example.assignmenta.Repository.ProductRespository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val productRespository: ProductRespository) : ViewModel() {

    lateinit var allProducts : LiveData<Products>
    init{
        viewModelScope.launch (Dispatchers.IO) {
            productRespository.getAllProducts()
        }
        allProducts = productRespository.allProducts
    }
}