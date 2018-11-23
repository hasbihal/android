package com.hasbihal

import android.content.Context
import org.json.JSONObject
import org.json.JSONException
import java.io.IOException


@Throws(IOException::class, JSONException::class)
fun loadJsonFile(context: Context, fileName: String): JSONObject {
    val `is` = context.getAssets().open(fileName)
    val size = `is`.available()
    val buffer = ByteArray(size)
    `is`.read(buffer)
    `is`.close()
    val jsonString = String(buffer)
    return JSONObject(jsonString)
}