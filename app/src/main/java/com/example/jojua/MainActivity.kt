package com.example.jojua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private lateinit var signUpEmailEditText: EditText
    private lateinit var signUpPasswordEditText: EditText
    private lateinit var registerButton: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
        signUpEmailEditText = findViewById(R.id.signUpEmailEditText)
        signUpPasswordEditText = findViewById(R.id.signUpPasswordEditText)
        registerButton = findViewById(R.id.signUpButton)
        registerButton.setOnClickListener {
            val email=signUpEmailEditText.text.toString()
            val password=signUpPasswordEditText.text.toString()
            if (email.isEmpty() && password.isEmpty()) {
                Toast.makeText(this, "please enter email and password", Toast.LENGTH_SHORT).show()}
            if (password.isEmpty() && email.isNotEmpty()){
                Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show()}
            if (email.isEmpty() && password.isNotEmpty()){
                    Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show()}
            if (email.isNotEmpty()&& password.isNotEmpty()) {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

                        }
                        else {
                            Toast.makeText(this, "Some kind of error has occurred", Toast.LENGTH_SHORT).show()
                        }


                    }


            }


        }
    }
}
