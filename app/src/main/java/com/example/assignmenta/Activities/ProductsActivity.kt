package com.example.assignmenta.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmenta.API.productService
import com.example.assignmenta.Adapter.ProductAdapter
import com.example.assignmenta.Repository.ProductApplication
import com.example.assignmenta.Repository.ProductRespository
import com.example.assignmenta.ViewModel.MainViewModel
import com.example.assignmenta.ViewModel.MainViewModelFactory
import com.example.assignmenta.databinding.ActivityProductsBinding

class ProductsActivity : AppCompatActivity() {
    lateinit var mainViewModel : MainViewModel
    private lateinit var binding : ActivityProductsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = (application as ProductApplication).productRespository
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository))[MainViewModel::class.java]

        initProducts()
    }
    private fun initProducts(){
        mainViewModel.allProducts.observe(this) {
            binding.productView.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL, false
            )
            binding.productView.adapter = ProductAdapter(it)
        }
    }
}