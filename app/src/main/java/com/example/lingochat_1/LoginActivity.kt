package com.example.lingochat_1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LoginActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var createAccountLink: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Initialize FirebaseAuth instance
        auth = FirebaseAuth.getInstance()

        // Initialize views
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)
        createAccountLink = findViewById(R.id.create_account_link)

        // Set click listener on login button
        loginButton.setOnClickListener {
            // Retrieve email and password from EditText fields
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validate email and password
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Attempt to sign in user with email and password
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, navigate to next screen (e.g., HomeScreenActivity)
                        val intent = Intent(this, ConversationActivity::class.java)
                        startActivity(intent)
                        finish() // Finish com.example.lingochat_1.LoginActivity to prevent user from going back
                    } else {
                        // If sign in fails, display a message to the user.
                        val errorMessage = task.exception?.message
                        if (errorMessage != null) {
                            if (task.exception is FirebaseAuthInvalidUserException) {
                                // User does not exist, display message to create account
                                Toast.makeText(this, "Account not found. Please create an account.", Toast.LENGTH_SHORT).show()
                            } else {
                                // Other authentication errors, display the error message
                                Toast.makeText(this, "Account not found. Please create an account.", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
        }

        // Set click listener on create account link
        createAccountLink.setOnClickListener {
            // Navigate to create account screen (CreateAccountActivity)
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}
