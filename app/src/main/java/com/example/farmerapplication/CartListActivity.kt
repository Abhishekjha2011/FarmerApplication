package com.example.farmerapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class CartListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_list)

        val productNameTextView: TextView = findViewById(R.id.cartProductName)
        val productPriceTextView: TextView = findViewById(R.id.cartProductPrice)
        val productImageView: ImageView = findViewById(R.id.cartProductImage)
        val selectedProductTitle: TextView = findViewById(R.id.selectedProductTitle)
        val buyNowButton: Button = findViewById(R.id.buyNowButton)
        val addToCartButton: Button = findViewById(R.id.addToCartButton)

        // Retrieve product data passed from the DashboardActivity
        val selectedProductName = intent.getStringExtra("productName") ?: "No Name"
        val selectedProductPrice = intent.getStringExtra("productPrice") ?: "No Price"
        val selectedProductImageResId = intent.getIntExtra("productImage", -1)

        // Set data to views
        selectedProductTitle.text = "Selected Product"
        productNameTextView.text = selectedProductName
        productPriceTextView.text = selectedProductPrice

        // Set the product image if resource ID is valid
        if (selectedProductImageResId != -1) {
            productImageView.setImageResource(selectedProductImageResId)
        } else {
            productImageView.setImageResource(R.drawable.question) // Default placeholder image
        }

        // Set OnClickListener for BUY NOW button
        buyNowButton.setOnClickListener {
            val intent = Intent(this, PurchaseActivity::class.java)
            intent.putExtra("PRODUCT_NAME", selectedProductName)
            intent.putExtra("PRODUCT_PRICE", selectedProductPrice)
            intent.putExtra("PRODUCT_IMAGE_RES_ID", selectedProductImageResId)
            startActivity(intent)
        }

        // Set OnClickListener for ADD TO CART button
        addToCartButton.setOnClickListener {
            // Show a message that the product was added to the cart
            Toast.makeText(this, "$selectedProductName added to cart for later", Toast.LENGTH_SHORT).show()
        }
    }
}
