package com.example.moxy_retrofit.data.api

import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

      @GET( "users/{userName}/repos")
    suspend fun getRepo(@Path("userName") userName: Int,
                        @Query("page") page: Int): Response<Repo>

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
