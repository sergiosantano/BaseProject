package com.ssantano.project.features.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.ssantano.project.common.android.extensions.inflater
import com.ssantano.project.common.android.recycler.providers.ItemViewHolderProvider
import com.ssantano.project.common.android.recycler.viewholder.ItemViewHolder
import com.ssantano.project.databinding.RowHomeBinding
import com.ssantano.project.features.home.adapter.viewholder.HomeViewHolder

class HomeViewHolderProvider : ItemViewHolderProvider<String>() {

    override val itemViewHolder: (parent: ViewGroup, viewType: Int) -> ItemViewHolder<String> =
        ::getHolder

    override val diffUtilCallback: DiffUtil.ItemCallback<String> =
        object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

        }

    private fun getHolder(viewGroup: ViewGroup, viewType: Int): ItemViewHolder<String> {
        return HomeViewHolder(
            RowHomeBinding.inflate(viewGroup.inflater(), viewGroup, false)
        )
    }
}