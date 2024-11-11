package com.example.farmerapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DeliveryActivity : AppCompatActivity() {

    private lateinit var homeAddressEditText: EditText
    private lateinit var pincodeEditText: EditText
    private lateinit var phoneNumberEditText: EditText
    private lateinit var stateRadioGroup: RadioGroup
    private lateinit var cityEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var paymentButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery)

        // Initialize views
        homeAddressEditText = findViewById(R.id.homeAddressEditText)
        pincodeEditText = findViewById(R.id.pincodeEditText)
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText)
        stateRadioGroup = findViewById(R.id.stateRadioGroup)
        cityEditText = findViewById(R.id.cityEditText)
        submitButton = findViewById(R.id.submitButton)
        paymentButton = findViewById(R.id.paymentButton)

        // Handle Submit button click
        submitButton.setOnClickListener {
            val homeAddress = homeAddressEditText.text.toString()
            val pincode = pincodeEditText.text.toString()
            val phoneNumber = phoneNumberEditText.text.toString()
            val selectedState = getSelectedState()
            val selectedCity = cityEditText.text.toString()

            if (homeAddress.isEmpty() || pincode.isEmpty() || phoneNumber.isEmpty() ||
                selectedState.isEmpty() || selectedCity.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Address Submitted: $homeAddress, $pincode, $phoneNumber, $selectedState, $selectedCity", Toast.LENGTH_LONG).show()
            }
        }

        // Handle Payment button click
        paymentButton.setOnClickListener {
            val url = "https://www.phonepe.com/how-to-pay/pay-by-phonepe/web/"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    // Function to get the selected state
    private fun getSelectedState(): String {
        val selectedId = stateRadioGroup.checkedRadioButtonId
        if (selectedId != -1) {
            val radioButton: RadioButton = findViewById(selectedId)
            return radioButton.text.toString()
        }
        return ""
    }
}
