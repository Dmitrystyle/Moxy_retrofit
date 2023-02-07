package com.example.moxy_retrofit.repository

import com.example.moxy_retrofit.api.RetrofitInstance
import com.example.moxy_retrofit.model.Post


class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}