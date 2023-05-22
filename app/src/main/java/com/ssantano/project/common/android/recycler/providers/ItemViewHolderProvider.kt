package com.ssantano.project.common.android.recycler.providers

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.ssantano.project.common.android.recycler.adapter.ItemPayload
import com.ssantano.project.common.android.recycler.viewholder.ItemViewHolder

abstract class ItemViewHolderProvider<Item> {

    abstract val itemViewHolder: (parent: ViewGroup, viewType: Int) -> ItemViewHolder<Item>

    abstract val diffUtilCallback: DiffUtil.ItemCallback<Item>

    open fun getItemViewType(position: Int, item: Item): Int = position

    open fun extractPayload(payloads: MutableList<Any>): ItemPayload? = null
}