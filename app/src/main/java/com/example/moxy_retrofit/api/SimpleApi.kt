package com.example.moxy_retrofit.api


import com.example.moxy_retrofit.model.Post
import retrofit2.http.GET

interface SimpleApi {

        @GET("posts/1")
        suspend fun getPost(): Post

    }
