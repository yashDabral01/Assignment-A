package com.example.assignmenta.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.assignmenta.Activities.ProductsDescriptionActivity
import com.example.assignmenta.databinding.ProductsViewholderBinding

class ProductAdapter(val items: com.example.assignmenta.Models.Products) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private var context: Context? = null

    class ViewHolder(val binding: ProductsViewholderBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding = ProductsViewholderBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = items.products.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.binding.productName.text = items.products[position].title
        holder.binding.brandName.text = items.products[position].brand

        val requestOptions = RequestOptions().transform(CenterCrop())
        Glide.with(holder.itemView.context)
            .load(items.products[position].images[0])
            .apply(requestOptions)
            .into(holder.binding.productImg)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProductsDescriptionActivity::class.java)
            intent.putExtra("object", items.products[position])
            holder.itemView.context.startActivity(intent)
        }
    }
}