package com.example.moxy_retrofit.data.api
import com.example.moxy_retrofit.data.model.Repo
import com.example.moxy_retrofit.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {
    @GET(Constants.GET_URL)

    suspend fun getRepo(@Path("userName") userName: String): List<Repo>

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
