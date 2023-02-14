package com.example.moxy_retrofit.api
import com.example.moxy_retrofit.model.Repo
import com.example.moxy_retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.net.URL


interface SimpleApi {

    @GET("users/{userName}/repos")

    suspend fun getRepo(@Path("userName") userName: String): List<Repo>

    companion object {
        fun create(): SimpleApi {

         val logger=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val okHttp=OkHttpClient.Builder().addInterceptor(logger)
            val builder=Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttp.build())

            val retrofit = builder.build()
               // .client()
           /*     .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()*/

            return retrofit.create(SimpleApi::class.java)

        }
      }


/*    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(Level.BASIC);
    OkHttpClient client = new OkHttpClient.Builder()
    .addInterceptor(logging)
    .build();





     val retrofit = Retrofit.Builder()
                .client()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()


    */

}
