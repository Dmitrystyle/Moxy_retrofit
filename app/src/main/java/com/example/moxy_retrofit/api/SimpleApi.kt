package com.example.moxy_retrofit.api


import com.example.moxy_retrofit.model.Post
import com.example.moxy_retrofit.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


//интерфейс обращения к ресурсу
interface SimpleApi {

    @GET("posts/1")
     fun getPost(): Call<Post>



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
