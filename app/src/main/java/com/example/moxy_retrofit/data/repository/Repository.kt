package com.example.moxy_retrofit.data.repository

import com.example.moxy_retrofit.data.api.SimpleApi
import com.example.moxy_retrofit.data.api.StarsApi

object Repository {

    private val api = SimpleApi.create()
        suspend fun getRepo(user: String) = api.getRepo(user)

    private val apiStars = StarsApi.create()
    suspend fun getSTARrepo(user: String, userRepositoryName: String) = apiStars.getRepoSTAR(user, userRepositoryName)

}