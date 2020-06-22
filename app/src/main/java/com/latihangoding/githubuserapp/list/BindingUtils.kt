package com.latihangoding.githubuserapp.list

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.latihangoding.githubuserapp.model.UserModel

@BindingAdapter("avatarImage")
fun ImageView.setAvatarImage(item: UserModel) {
    val id = context.resources.getIdentifier(item.avatar.replace("@drawable/", ""), "drawable", context.packageName)
    setImageResource(id)
}