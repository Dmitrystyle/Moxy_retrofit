package com.example.moxy_retrofit.data.api

import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
//https://api.github.com/repos/Lajesh/Android-MVVM
//Lajesh/Android-MVVM

interface GetSTARApi {
    @GET( "repos/{userName}/{userRepositoryName}")

    suspend fun getRepo(@Path("userName") userName: String, @Path("userRepositoryName") userRepositoryName: String ): List<Repo>

    companion object {
        fun create(): GetSTARApi {

           val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                val clientOKHTTP: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(logging)


            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientOKHTTP.build())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(GetSTARApi::class.java)
        }
      }

}
