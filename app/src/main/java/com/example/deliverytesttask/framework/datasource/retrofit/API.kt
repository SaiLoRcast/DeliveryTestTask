package com.example.deliverytesttask.framework.datasource.retrofit

import com.example.core.domain.User
import com.example.core.domain.UsersData
import com.example.deliverytesttask.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface API {

    @GET("/data/api/user/{userId}")
    fun getUserInfo(@Header("app-id") appId:String , @Path("userId") userId: String): Call<User>

    @GET("/data/api/user")
    fun getUsersList(@Header("app-id") appId: String): Call<UsersData>

    companion object {
        fun getAPI(): API {

            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder().addInterceptor(logger).build()

            val api = retrofit2.Retrofit.Builder().apply {
                addConverterFactory(GsonConverterFactory.create())
                baseUrl(BuildConfig.BASE_URL)
                client(client)
            }

            return api.build().create(API::class.java)
        }
    }
}