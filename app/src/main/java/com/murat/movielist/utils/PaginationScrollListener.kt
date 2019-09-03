package com.murat.movielist.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Furkan on 2019-07-02
 */

/**
 * Pagination class to add more items to the list when reach the last item.
 */
abstract class PaginationScrollListener
/**
 * Supporting only LinearLayoutManager for now.
 *
 * @param layoutManager
 */
(var layoutManager: androidx.recyclerview.widget.LinearLayoutManager) : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {

    abstract fun isLastPage(): Boolean

    abstract fun isLoading(): Boolean

    override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

        if (!isLoading() && !isLastPage()) {
            if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                loadMoreItems()
            }
        }
    }

    abstract fun loadMoreItems()
}