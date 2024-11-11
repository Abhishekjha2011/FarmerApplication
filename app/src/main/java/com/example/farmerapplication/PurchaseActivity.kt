package com.example.farmerapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)


        val productNameTextView: TextView = findViewById(R.id.purchaseProductName)
        val productPriceTextView: TextView = findViewById(R.id.purchaseProductPrice)
        val productImageView: ImageView = findViewById(R.id.purchaseProductImage)
        val deliveryAddressButton: Button = findViewById(R.id.deliveryAddressButton)


        val productName = intent.getStringExtra("PRODUCT_NAME") ?: "No Name"
        val productPrice = intent.getStringExtra("PRODUCT_PRICE") ?: "No Price"
        val productImageResId = intent.getIntExtra("PRODUCT_IMAGE_RES_ID", -1)

        // Set the product details to the respective views
        productNameTextView.text = productName
        productPriceTextView.text = productPrice

        // Set the product image if the image resource ID is valid
        if (productImageResId != -1) {
            productImageView.setImageResource(productImageResId)
        } else {
            productImageView.setImageResource(R.drawable.question) // Default placeholder
        }

        // Set onClickListener for the "Delivery Address" button
        deliveryAddressButton.setOnClickListener {
            val intent = Intent(this, DeliveryActivity::class.java)
            startActivity(intent)
        }
    }
}
