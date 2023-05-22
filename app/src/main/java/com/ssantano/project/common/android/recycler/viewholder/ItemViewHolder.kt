package com.ssantano.project.common.android.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ssantano.project.common.android.recycler.adapter.ItemPayload

typealias OnItemClickListener = (view: View, item: Any) -> Unit

abstract class ItemViewHolder<Item>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: Item, position: Int)
    open fun bind(data: Item, position: Int, payload: ItemPayload) { bind(data, position) }
    open fun afterBind(data: Item, position: Int) {}
    open fun onViewAttachedToWindow() {}
    open fun onViewDetachedFromWindow() {}
    open fun setOnItemClickListener(onItemClickListener: OnItemClickListener?, item: Item, position: Int) {}
    open fun setOnItemLongClickListener(onItemLongClickListener: OnItemClickListener?, item: Item, position: Int) {}
}