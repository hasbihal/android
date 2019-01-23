package com.hasbihal.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.hasbihal.R
import timber.log.Timber

class LoginActivity : AppCompatActivity() {

    lateinit var fireBaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fireBaseAuth = FirebaseAuth.getInstance()

        fireBaseAuth.createUserWithEmailAndPassword("ugurcmk@gmail.com", "12345678")
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Timber.d("The task is successfully completed")
                    } else {
                        Timber.d("There is an error : "+task.exception)
                    }
                }
    }
}
