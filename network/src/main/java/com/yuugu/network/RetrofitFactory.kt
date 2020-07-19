package com.yuugu.network

import android.util.Log
import com.google.gson.Gson

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory private constructor() {

    private val retrofit: Retrofit

    init {
        val gson = Gson().newBuilder()
//                .setLenient()
//                .serializeNulls()
                .create()

        retrofit = Retrofit.Builder()
                .baseUrl("http://192.168.43.162:3000")
                .client(initOkhttpClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    companion object {
        val instance: RetrofitFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitFactory()
        }
    }

    private fun initOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(initLogInterceptor())
                .build()
    }

    private fun initLogInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.i("Retrofit", message)
            }
        })
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> getService(service: Class<T>): T {
        return retrofit.create(service)
    }
}


