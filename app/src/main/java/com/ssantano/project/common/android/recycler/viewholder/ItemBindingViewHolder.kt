package com.ssantano.project.common.android.recycler.viewholder

import androidx.viewbinding.ViewBinding

abstract class ItemBindingViewHolder<Item, Binding : ViewBinding>(protected val binding: Binding) :
    ItemViewHolder<Item>(binding.root)