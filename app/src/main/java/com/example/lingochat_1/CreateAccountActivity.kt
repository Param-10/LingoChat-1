package com.example.lingochat_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var createAccountButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        Log.d("CreateAccountActivity", "onCreate executed")
        // Initialize views
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        createAccountButton = findViewById(R.id.create_account_button2)

        // Set click listener on create account button
        createAccountButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate email and password
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create account using Firebase Authentication
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Account creation success
                        FirebaseAuth.getInstance().currentUser
                        if (task.result?.additionalUserInfo?.isNewUser == true) {
                            // Account was newly created
                            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                        } else {
                            // User logs in directly
                            Toast.makeText(this, "You are logged in", Toast.LENGTH_SHORT).show()
                        }
                        // Navigate to the next screen (e.g., Home Screen or Conversation Screen)
                        val intent = Intent(this, LoginActivity::class.java)
                        // Start the activity
                        startActivity(intent)
                        // Add your navigation logic here
                    } else {
                        // Account creation failed
                        Toast.makeText(this, "Account creation failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
