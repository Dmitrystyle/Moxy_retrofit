package com.example.moxy_retrofit.data.api


class ApiHelper(private val apiService: ApiService) {

    suspend fun getRepo(user:String) = apiService.getRepo(user)
}