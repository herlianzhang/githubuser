package com.latihangoding.githubuserapp.list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.latihangoding.githubuserapp.R
import com.latihangoding.githubuserapp.databinding.ActivityListBinding
import com.latihangoding.githubuserapp.detail.DetailActivity
import com.latihangoding.githubuserapp.model.GithubModel
import com.latihangoding.githubuserapp.model.UserModel

class ListActivity : AppCompatActivity(), ListViewAdapter.OnClickListener {



    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        val githubData = intent.getParcelableExtra(USER_DATA) as GithubModel
        val viewModelFactory = ListViewModelFactory(githubData.users)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListViewModel::class.java)
        binding.lifecycleOwner = this

        val adapter = ListViewAdapter(this)
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

    override fun onListClick(model: UserModel, pair: Pair<View, String>) {
        val optionCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pair.first, pair.second)
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(USER_DATA, model as Parcelable)
        startActivity(intent, optionCompat.toBundle())
    }

    companion object {
        const val USER_DATA = "USER_DATA"
    }
}