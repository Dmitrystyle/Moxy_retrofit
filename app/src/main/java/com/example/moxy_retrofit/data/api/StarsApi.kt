package com.example.moxy_retrofit.data.api

import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.data.model.Stars
import com.example.moxy_retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface StarsApi {

    @Headers("Accept: application/vnd.github.star+json")
    @GET( "repos/{userName}/{userRepositoryName}/stargazers")
    suspend fun getRepoSTAR(@Path("userName") userName: String, @Path("userRepositoryName") userRepositoryName: String ): List<Stars>

    companion object {
        fun create(): StarsApi {

           val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                val clientOKHTTP: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientOKHTTP.build())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(StarsApi::class.java)
        }
      }

}
