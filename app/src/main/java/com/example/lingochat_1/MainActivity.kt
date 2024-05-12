package com.example.lingochat_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up intent to launch HomeScreenActivity
        val intent = Intent(this, HomeScreenActivity::class.java)
        startActivity(intent)
        // Add this code in your MainActivity
        FirebaseApp.initializeApp(this)
        // Find the Create Account button by its ID
        val createAccountButton = findViewById<Button>(R.id.create_account_button)

        // Set a click listener on the Create Account button
        createAccountButton.setOnClickListener {
            // Navigate to the CreateAccountActivity
            startActivity(Intent(this, CreateAccountActivity::class.java))


            // Optionally, you can finish the MainActivity so that it's not in the back stack
            finish()
        }
    }
}
