package com.example.moxy_retrofit.data.repository

import com.example.moxy_retrofit.data.api.SimpleApi

object Repository {

    private val api = SimpleApi.create()
    suspend fun getRepo(user: String) = api.getRepo(user)

}