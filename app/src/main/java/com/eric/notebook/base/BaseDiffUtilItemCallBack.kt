package com.eric.notebook.base

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

interface BaseDiffUtilItemCallBack {
    val id: Int

    class Base<B : BaseDiffUtilItemCallBack> : DiffUtil.ItemCallback<B>() {

        override fun areItemsTheSame(oldItem: B, newItem: B) = oldItem.id == newItem.id

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: B, newItem: B) = oldItem == newItem

    }
}