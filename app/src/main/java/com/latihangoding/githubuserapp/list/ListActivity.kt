package com.latihangoding.githubuserapp.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.service.autofill.UserData
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.ListView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
        val viewModelFactory = ListViewModelFactory(githubData.users)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
        Log.d("masukpakeko", "${githubData.users}")
        binding.setLifecycleOwner(this)

        val adapter = ListViewAdapter()
        binding.rvMain.adapter = adapter

        binding.ivSearch.setOnClickListener {
            searchName()
        }

        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                searchName()
            }
            true
        }

        viewModel.usersModel.observe(this, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })
    }

    private fun searchName() {
        viewModel.showData(binding.etSearch.text.toString())
        binding.rvMain.smoothScrollToPosition(0)
    }
}