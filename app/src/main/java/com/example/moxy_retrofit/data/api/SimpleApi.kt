package com.example.moxy_retrofit.data.api

import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET( "users/{userName}/repos")
    suspend fun getRepo(@Path("userName") userName: String): List<Repo>

    @GET( "repos/{userName}/{userRepositoryName}")
    suspend fun getRepoSTAR(@Path("userName") userName: String, @Path("userRepositoryName") userRepositoryName: String ): List<Repo>

    //https://api.github.com/repos/Dmitrystyle/Retrofit/stargazers
    //application/vnd.github.star+json

    companion object {
        fun create(): SimpleApi {

           val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                val clientOKHTTP: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientOKHTTP.build())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(SimpleApi::class.java)
        }
      }

}
