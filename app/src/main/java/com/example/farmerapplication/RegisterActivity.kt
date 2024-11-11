package com.example.farmerapplication


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextPhoneNumber = findViewById<EditText>(R.id.editTextPhoneNumber)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)

        buttonSubmit.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val phoneNumber = editTextPhoneNumber.text.toString()
            val address = editTextAddress.text.toString()

            // Check if fields are not empty
            if (username.isNotEmpty() && password.isNotEmpty() &&
                phoneNumber.isNotEmpty() && address.isNotEmpty()) {

                // Save username and password to SharedPreferences
                val sharedPref: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.apply()

                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                // Navigate to LoginActivity after registration
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                // Clear input fields after submission
                editTextUsername.text.clear()
                editTextPassword.text.clear()
                editTextPhoneNumber.text.clear()
                editTextAddress.text.clear()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
