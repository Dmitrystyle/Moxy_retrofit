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
            val response = apiService.getRepo(currentPage)
            val responseData = mutableListOf<Repo>()
            val data = response.body()?.name?: emptyList()
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