package com.example.projet_annuel

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val button = findViewById<Button>(R.id.btn_register)
        val emailText = findViewById<TextInputEditText>(R.id.register_email)
        val passwordText = findViewById<TextInputEditText>(R.id.register_password)
        val loginAccount = findViewById<TextView>(R.id.login_account)

        loginAccount.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
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

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->
                                if (task.isSuccessful) {
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    Toast.makeText(
                                        this,
                                        "Inscription Réussi.",
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    val intent = Intent(this, MainActivity::class.java)
                                    intent.flags =
                                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
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
                            })
                }
            }
        }
    }
}