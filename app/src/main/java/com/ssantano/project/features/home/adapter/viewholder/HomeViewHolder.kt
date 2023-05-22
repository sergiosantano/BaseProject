package com.ssantano.project.features.home.adapter.viewholder

import com.ssantano.project.common.android.recycler.viewholder.ItemBindingViewHolder
import com.ssantano.project.databinding.RowHomeBinding

class HomeViewHolder(binding: RowHomeBinding): ItemBindingViewHolder<String, RowHomeBinding>(binding) {

    override fun bind(data: String, position: Int) {
        binding.fragmentHomeLabelTest.text = data
    }
}