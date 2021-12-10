

package com.dd.baseui.recyclerview.listener

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dd.baseui.recyclerview.BindingAdapter
import com.dd.baseui.recyclerview.item.ItemDrag
import com.dd.baseui.recyclerview.item.ItemSwipe
import com.dd.baseui.recyclerview.utils.bindingAdapter
import java.util.*

/**
 * 默认实现拖拽替换和侧滑删除
 */
open class DefaultItemTouchCallback : ItemTouchHelper.Callback() {

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val adapter = viewHolder.bindingAdapter as? BindingAdapter
        val layoutPosition = viewHolder.layoutPosition
        adapter?.notifyItemRemoved(layoutPosition)
        (adapter?.models as ArrayList).removeAt(layoutPosition)
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
    ): Int {
        var drag = 0
        var swipe = 0
        if (viewHolder is BindingAdapter.BindingViewHolder) {
            val model = viewHolder.getModel<Any>()
            if (model is ItemDrag) drag = model.itemOrientationDrag
            if (model is ItemSwipe) swipe = model.itemOrientationSwipe
        }
        return makeMovementFlags(drag, swipe)
    }


    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            val swipeView = viewHolder.itemView.findViewWithTag<View>("swipe")
            if (swipeView != null) {
                swipeView.translationX = dX
            } else {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        } else {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
        }
    }

    override fun getSwipeThreshold(viewHolder: RecyclerView.ViewHolder): Float {
        return 1f
    }

    /**
     * 当拖拽动作完成且松开手指时触发
     */
    open fun onDrag(
        source: BindingAdapter.BindingViewHolder, target: BindingAdapter.BindingViewHolder
    ) {

    }

    private var lastActionState: Int = 0
    private var sourceViewHolder: BindingAdapter.BindingViewHolder? = null
    private var targetViewHolder: BindingAdapter.BindingViewHolder? = null

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        when (actionState) {
            ItemTouchHelper.ACTION_STATE_IDLE -> {
                if (lastActionState == ItemTouchHelper.ACTION_STATE_DRAG &&
                    sourceViewHolder is BindingAdapter.BindingViewHolder &&
                    targetViewHolder is BindingAdapter.BindingViewHolder) {
                    onDrag(sourceViewHolder!!, targetViewHolder!!)
                }
            }
            else -> {
                this.lastActionState = actionState
            }
        }
    }

    override fun onMove(
        recyclerView: RecyclerView, source: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder
    ): Boolean {

        val adapter = recyclerView.bindingAdapter as? BindingAdapter ?: return false
        val currentPosition = recyclerView.getChildLayoutPosition(source.itemView)
        val targetPosition = recyclerView.getChildLayoutPosition(target.itemView)

        if (source is BindingAdapter.BindingViewHolder && target is BindingAdapter.BindingViewHolder) {
            val model = target.getModel<Any>()
            if (model is ItemDrag && model.itemOrientationDrag != 0) {
                adapter.notifyItemMoved(currentPosition, targetPosition)
                Collections.swap(adapter.mutable, currentPosition - adapter.headerCount, targetPosition - adapter.headerCount)
                sourceViewHolder = source
                targetViewHolder = target
            }
        }
        return false
    }
}