package com.latihangoding.githubuserapp.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.latihangoding.githubuserapp.model.UserModel

class ListViewModelFactory(private val data: List<UserModel>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListViewModel::class.java)) {
            return ListViewModel(data) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}