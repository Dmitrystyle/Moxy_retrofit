package com.example.moxy_retrofit.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.moxy_retrofit.data.api.SimpleApi
import com.example.moxy_retrofit.data.model.Repo

class PagingSource
    (
    private val apiService: SimpleApi
) : PagingSource<Int, Repo>() {

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>):
            LoadResult<Int, Repo> {

        return try {
            val currentPage:Int = params.key ?: 1
            val response = apiService.getAllCharacters(currentPage)
            val responseData = mutableListOf<Repo>()
            val data = response.body() ?: emptyList()
            responseData.addAll(data)

            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}

/*
override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Int> {
    val pageIndex = checkNotNull(params.key) { "key should not be null" }
    val loadSize = params.loadSize
    val page = pageRepository.getPage(pageIndex, loadSize)

    val newCount = page.items.size
    val total = page.total
    val itemsBefore = pageIndex * PAGE_SIZE
    val itemsAfter = total - (itemsBefore + newCount)

    val prevKey = if (pageIndex == 0) null else pageIndex - 1
    val nextKey = if (itemsAfter == 0) null else pageIndex + 1

    return LoadResult.Page(
        data = page.items,
        prevKey = prevKey,
        nextKey = nextKey,
        itemsBefore = itemsBefore,
        itemsAfter = itemsAfter,
    )
}
}*/
