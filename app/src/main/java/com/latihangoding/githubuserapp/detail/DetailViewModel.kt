package com.latihangoding.githubuserapp.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.latihangoding.githubuserapp.model.UserModel

class DetailViewModel(userData: UserModel) : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _avatar = MutableLiveData<String>()
    val avatar: LiveData<String>
        get() = _avatar

    private val _company = MutableLiveData<String>()
    val company: LiveData<String>
        get() = _company

    private val _location = MutableLiveData<String>()
    val location: LiveData<String>
        get() = _location

    private val _repository = MutableLiveData<Int>()
    val repository: LiveData<Int>
        get() = _repository

    private val _follower = MutableLiveData<Int>()
    val follower: LiveData<Int>
        get() = _follower

    private val _following = MutableLiveData<Int>()
    val following: LiveData<Int>
        get() =_following

    init {
        _username.value = userData.username
        _name.value = userData.name
        _avatar.value = userData.avatar
        _company.value = userData.company
        _location.value = userData.location
        _repository.value = userData.repository
        _follower.value = userData.follower
        _following.value = userData.following
    }
}