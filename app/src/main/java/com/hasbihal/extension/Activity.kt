package com.hasbihal.extension

import android.app.Activity
import android.app.ProgressDialog

fun Activity.showProgressDialog(){
    val progressDialog = ProgressDialog(this)
    progressDialog.setTitle("Loading")
    progressDialog.show()
}
