package com.latihangoding.githubuserapp

import androidx.lifecycle.ViewModel
import com.latihangoding.githubuserapp.model.GithubModel
import java.io.IOException
import java.io.InputStream

class MainViewModel : ViewModel() {

    lateinit var githubModel: GithubModel

    fun inputStreamToString(inputStream: InputStream): String? {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            null
        }
    }
}