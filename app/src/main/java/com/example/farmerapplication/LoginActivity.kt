package com.example.farmerapplication
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextLoginUsername = findViewById<EditText>(R.id.editTextLoginUsername)
        val editTextLoginPassword = findViewById<EditText>(R.id.editTextLoginPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = editTextLoginUsername.text.toString()
            val password = editTextLoginPassword.text.toString()

            val sharedPref: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val registeredUsername = sharedPref.getString("username", "")
            val registeredPassword = sharedPref.getString("password", "")


            if (username == registeredUsername && password == registeredPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
