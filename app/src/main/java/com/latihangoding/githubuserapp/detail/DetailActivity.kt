package com.latihangoding.githubuserapp.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.latihangoding.githubuserapp.R
import com.latihangoding.githubuserapp.databinding.ActivityDetailBinding
import com.latihangoding.githubuserapp.list.ListActivity
import com.latihangoding.githubuserapp.model.UserModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        window.sharedElementEnterTransition = TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transation)
        val userData = intent.getParcelableExtra(ListActivity.USER_DATA) as UserModel
        val viewModelFactory = DetailViewModelFactory(userData)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}