package com.example.projet_annuel

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button = findViewById<Button>(R.id.btn_login)
        val emailText = findViewById<TextInputEditText>(R.id.login_email)
        val passwordText = findViewById<TextInputEditText>(R.id.login_password)
        val registerAccount = findViewById<TextView>(R.id.register_account)

        registerAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        button.setOnClickListener {
            when {
                TextUtils.isEmpty(emailText.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Entrez un email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(passwordText.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this,
                        "Entrez un mot passe.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = emailText.text.toString().trim { it <= ' ' }
                    val password: String = passwordText.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this,
                                    "Connexion Réussie.",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent = Intent(this, MainActivity::class.java)
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra(
                                    "user_id",
                                    FirebaseAuth.getInstance().currentUser!!.uid
                                )
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
}