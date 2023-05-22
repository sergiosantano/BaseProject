package com.ssantano.project.common.android.recycler.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ssantano.project.common.android.recycler.providers.ItemViewHolderProvider
import com.ssantano.project.common.android.recycler.viewholder.ItemViewHolder

typealias OnItemClickListener = (view: View, item: Any) -> Unit

class ItemsAdapter<Item>(private val viewHolderProvider: ItemViewHolderProvider<Item>) :
    ListAdapter<Item, ItemViewHolder<Item>>(viewHolderProvider.diffUtilCallback) {

    var clickListener: OnItemClickListener? = null
    var longClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<Item> =
        viewHolderProvider.itemViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: ItemViewHolder<Item>, position: Int) {
        getItem(position)?.let { item ->
            holder.bind(item, position)
            holder.setOnItemClickListener(clickListener, item, position)
            holder.setOnItemLongClickListener(longClickListener, item, position)
            holder.afterBind(item, position)
        }
    }

    override fun onBindViewHolder(
        holder: ItemViewHolder<Item>,
        position: Int,
        payloads: MutableList<Any>
    ) {
        getItem(position)?.let { item ->
            viewHolderProvider.extractPayload(payloads)?.let { payloadToApply ->
                holder.bind(item, position, payloadToApply)
                holder.afterBind(item, position)
            } ?: kotlin.run { onBindViewHolder(holder, position) }
        }
    }

    override fun getItemViewType(position: Int): Int =
        viewHolderProvider.getItemViewType(position, currentList[position])

    override fun getItemCount(): Int = currentList.size

    override fun getItem(position: Int): Item? = currentList.getOrNull(position)

    override fun onViewAttachedToWindow(holder: ItemViewHolder<Item>) {
        super.onViewAttachedToWindow(holder)
        holder.onViewAttachedToWindow()
    }

    override fun onViewDetachedFromWindow(holder: ItemViewHolder<Item>) {
        super.onViewDetachedFromWindow(holder)
        holder.onViewDetachedFromWindow()
    }
}

interface ItemPayload