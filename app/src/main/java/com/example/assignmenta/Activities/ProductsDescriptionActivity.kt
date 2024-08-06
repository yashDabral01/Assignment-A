package com.example.assignmenta.Activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.assignmenta.Models.Product
import com.example.assignmenta.R
import com.example.assignmenta.databinding.ActivityProductsDescriptionBinding

class ProductsDescriptionActivity : AppCompatActivity() {
    private lateinit var item : Product
    private lateinit var binding:ActivityProductsDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
       initdetails()
    }
    private fun initdetails(){
        item = intent.getParcelableExtra("object")!!
        binding.stock.text = item.stock.toString()
        binding.priceText.text = item.price.toString()
        binding.ratingText.text = item.rating.toString()
        binding.desciptionText.text = item.description
        binding.warrantyInfoText.text = item.warrantyInformation
        binding.shippingInfoText.text = item.shippingInformation

        val requestOptions = RequestOptions().placeholder(R.drawable.ic_launcher_background)
        Glide.with(this)
            .load(item.images[0])
            .apply(requestOptions)
            .into(binding.productImg)

    }
}