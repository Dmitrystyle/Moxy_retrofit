package com.example.moxy_retrofit.data.repository

import com.example.moxy_retrofit.data.api.ApiHelper

class Repository(private val apiHelper: ApiHelper) {

    suspend fun getRepo(user: String) = apiHelper.getRepo(user)


}