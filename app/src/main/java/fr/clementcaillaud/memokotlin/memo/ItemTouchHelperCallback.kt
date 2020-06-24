package fr.clementcaillaud.memokotlin.memo

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.RecyclerView

class ItemTouchHelperCallback(adapter: MemoAdapter) : ItemTouchHelper.Callback()
{
    private val adapter: MemoAdapter = adapter

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int
    {
        val dragFlagsRight = RIGHT
        return makeMovementFlags(dragFlagsRight, dragFlagsRight)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean
    {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int)
    {
        adapter.onItemDismiss(viewHolder)
        adapter.notifyDataSetChanged()
    }
}