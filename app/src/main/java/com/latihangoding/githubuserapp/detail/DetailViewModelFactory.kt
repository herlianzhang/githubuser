package com.latihangoding.githubuserapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.latihangoding.githubuserapp.model.UserModel

class DetailViewModelFactory(private val userData: UserModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(userData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}