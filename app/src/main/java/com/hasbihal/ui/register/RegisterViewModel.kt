package com.hasbihal.ui.register

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.hasbihal.data.model.User
import timber.log.Timber

class RegisterViewModel: ViewModel() {
    val fireBaseAuth = FirebaseAuth.getInstance()

    // TODO : Covert the arguments to user model object
    fun register(mail: String, password: String) {
        fireBaseAuth.createUserWithEmailAndPassword(mail, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Timber.d("The task is successfully completed")
                    } else {
                        Timber.d("There is an error : "+task.exception)
                    }
                }
    }
}