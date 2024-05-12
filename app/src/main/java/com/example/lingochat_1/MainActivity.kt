package com.example.lingochat_1

import android.content.Intent
import android.os.Bundle
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


        // Optionally, you can finish the MainActivity so that it's not in the back stack
        finish()
    }
}
