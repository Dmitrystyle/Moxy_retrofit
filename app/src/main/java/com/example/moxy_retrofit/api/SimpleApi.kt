package com.example.moxy_retrofit.api


import com.example.moxy_retrofit.utils.Constants
import com.example.moxy_retrofit.model.Repo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


//интерфейс обращения к ресурсу
interface SimpleApi {

    @GET("users/{userName}/repos")

    suspend fun getRepo(@Path("userName") user: String
    ): Call<List<Repo>>

    companion object {
        fun create(): SimpleApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()

            return retrofit.create(SimpleApi::class.java)

        }
      }

}
