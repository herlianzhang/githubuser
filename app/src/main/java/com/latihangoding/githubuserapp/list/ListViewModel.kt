package com.latihangoding.githubuserapp.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.latihangoding.githubuserapp.model.UserModel

class ListViewModel(data: List<UserModel>) : ViewModel() {

    val data: List<UserModel>?
    private val _usersModel = MutableLiveData<List<UserModel>>()
    val usersModel: LiveData<List<UserModel>>
        get() = _usersModel

    init {
        this.data = data
        _usersModel.postValue(data)
    }

    fun showData(keyword: String = "") {
        _usersModel.postValue(data?.filter { it.name.contains(keyword, true) || it.company.contains(keyword, true) || it.location.contains(keyword, true) })
    }
}