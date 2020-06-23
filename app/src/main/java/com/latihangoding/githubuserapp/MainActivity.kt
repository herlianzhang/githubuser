package com.latihangoding.githubuserapp

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.latihangoding.githubuserapp.databinding.ActivityMainBinding
import com.latihangoding.githubuserapp.list.ListActivity
import com.latihangoding.githubuserapp.model.GithubModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.lifecycleOwner = this

        getData()
        playAnimation()
    }

    private fun playAnimation() {
        binding.animationView.playAnimation()
        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                pushToList()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationStart(animation: Animator?) {

            }
        })
    }

    private fun pushToList() {
        val intent = Intent(this@MainActivity, ListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra(ListActivity.USER_DATA, mainViewModel.githubModel)
        startActivity(intent)
    }

    private fun getData() {
        val myJson = mainViewModel.inputStreamToString(resources.openRawResource(R.raw.githubuser))
        mainViewModel.githubModel = Gson().fromJson(myJson, GithubModel::class.java)
    }
}