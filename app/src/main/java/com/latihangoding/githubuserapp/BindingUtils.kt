package com.latihangoding.githubuserapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("avatarImage")
fun ImageView.setAvatarImage(avatar: String) {
    val id = context.resources.getIdentifier(avatar.replace("@drawable/", ""), "drawable", context.packageName)
    setImageResource(id)
}