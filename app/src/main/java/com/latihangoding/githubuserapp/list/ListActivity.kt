package com.latihangoding.githubuserapp.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.service.autofill.UserData
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.latihangoding.githubuserapp.R
import com.latihangoding.githubuserapp.databinding.ActivityListBinding
import com.latihangoding.githubuserapp.model.GithubModel
import com.latihangoding.githubuserapp.model.UserModel

class ListActivity : AppCompatActivity() {

    companion object {
        val userData = "USER_DATA"
    }
    lateinit var data: List<UserModel>

    lateinit var binding: ActivityListBinding
    lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        val githubData = intent.getParcelableExtra(userData) as GithubModel
        data = githubData.users
        Log.d("masukpakeko", "$data")
        binding.setLifecycleOwner(this)
    }
}