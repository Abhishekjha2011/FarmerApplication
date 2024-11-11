package com.example.farmerapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Create a list of products with their respective image resource IDs
        val products = listOf(
            Product("Apple", R.drawable.apple, "₹ 120"),
            Product("Banana", R.drawable.banana, "₹ 60"),
            Product("Carrot", R.drawable.carrot, "₹ 50"),
            Product("Potato", R.drawable.potato, "₹ 80"),
            Product("Onion", R.drawable.onion, "₹ 100"),
            Product("Tomato", R.drawable.tomato, "₹ 70")
        )

        // Set OnClickListener for each product image
        findViewById<ImageView>(R.id.productImage1).setOnClickListener {
            val product = products[0]
            // Display product selected message
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            // Start CartListActivity with the product data
            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.productImage2).setOnClickListener {
            val product = products[1]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }

        // Repeat for other product images...
        findViewById<ImageView>(R.id.productImage3).setOnClickListener {
            val product = products[2]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.productImage4).setOnClickListener {
            val product = products[3]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.productImage5).setOnClickListener {
            val product = products[4]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.productImage6).setOnClickListener {
            val product = products[5]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }

        findViewById<ImageView>(R.id.productImage7).setOnClickListener {
            val product = products[6]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.productImage8).setOnClickListener {
            val product = products[7]
            Toast.makeText(this, "${product.name} selected", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, CartListActivity::class.java).apply {
                putExtra("productName", product.name)
                putExtra("productPrice", product.price)
                putExtra("productImage", product.imageResId)
            }
            startActivity(intent)
        }
        findViewById<Button>(R.id.viewCartButton).setOnClickListener {
            val intent = Intent(this, CartListActivity::class.java)
            startActivity(intent)
        }
    }
}
