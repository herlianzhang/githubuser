package com.latihangoding.githubuserapp.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.latihangoding.githubuserapp.databinding.ListItemBinding
import com.latihangoding.githubuserapp.model.UserModel


class ListViewAdapter(private val onClickListener: OnClickListener) : ListAdapter<UserModel, ListViewAdapter.ViewHolder>(ListDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClickListener)
    }

    class ViewHolder private constructor(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UserModel, onClickListener: OnClickListener) {
            binding.model = item
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                val pair: Pair<View, String> = Pair(binding.ciAvatar, binding.ciAvatar.transitionName)
                onClickListener.onListClick(item, pair)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater =  LayoutInflater.from(parent.context)
                val binding = ListItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    interface OnClickListener {
        fun onListClick(model: UserModel, pair: Pair<View, String>)
    }
}

class ListDiffCallBack() : DiffUtil.ItemCallback<UserModel>() {
    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.username == newItem.username
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}