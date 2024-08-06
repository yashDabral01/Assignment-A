package com.example.assignmenta.Models

import android.os.Parcel
import android.os.Parcelable

data class Product(
    val availabilityStatus: String,
    val brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val minimumOrderQuantity: Int,
    val price: Double,
    val rating: Double,
    val returnPolicy: String,
    val shippingInformation: String,
    val sku: String,
    val stock: Int,
    val thumbnail: String,
    val title: String,
    val warrantyInformation: String,
    val weight: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        availabilityStatus = parcel.readString() ?: "",
        brand = parcel.readString() ?: "",
        category = parcel.readString() ?: "",
        description = parcel.readString() ?: "",
        discountPercentage = parcel.readDouble(),
        id = parcel.readInt(),
        images = parcel.createStringArrayList() ?: emptyList(),
        minimumOrderQuantity = parcel.readInt(),
        price = parcel.readDouble(),
        rating = parcel.readDouble(),
        returnPolicy = parcel.readString() ?: "",
        shippingInformation = parcel.readString() ?: "",
        sku = parcel.readString() ?: "",
        stock = parcel.readInt(),
        thumbnail = parcel.readString() ?: "",
        title = parcel.readString() ?: "",
        warrantyInformation = parcel.readString() ?: "",
        weight = parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(availabilityStatus)
        parcel.writeString(brand)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeDouble(discountPercentage)
        parcel.writeInt(id)
        parcel.writeStringList(images)
        parcel.writeInt(minimumOrderQuantity)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeString(returnPolicy)
        parcel.writeString(shippingInformation)
        parcel.writeString(sku)
        parcel.writeInt(stock)
        parcel.writeString(thumbnail)
        parcel.writeString(title)
        parcel.writeString(warrantyInformation)
        parcel.writeInt(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
