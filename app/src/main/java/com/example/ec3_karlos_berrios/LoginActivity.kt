package com.example.ec3_karlos_berrios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val usernameEditText: EditText = findViewById(R.id.editTextUsername)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        val loginButton: Button = findViewById(R.id.buttonLogin)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()


            if (isValidCredentials(username, password)) {

                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                finish()
            } else {

                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun isValidCredentials(username: String, password: String): Boolean {

        return username == "ejemplo@idat.edu.pe" && password == "123456"
    }
}