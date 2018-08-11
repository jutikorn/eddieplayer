package com.jutikorn.eddieplayer.common.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.jutikorn.eddieplayer.BuildConfig
import com.jutikorn.eddieplayer.api.EddiePlayerApi
import com.jutikorn.eddieplayer.common.Constants
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetModule private constructor(context: Context) {

    companion object : Constants.SingletonHolder<NetModule, Context>(::NetModule)

    val gson by lazy { GsonBuilder().create() }

    val gsonConverter: GsonConverterFactory by lazy { GsonConverterFactory.create(gson) }

    val logging by lazy {
        HttpLoggingInterceptor().apply {
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    val cache by lazy {
        Cache(context.applicationContext.cacheDir, 10L * 1024L * 1024L) // 10 MiB
    }


    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .cache(cache).build()
    }

    val retrofit by lazy {
        Retrofit.Builder()
                .addConverterFactory(gsonConverter)
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(okHttpClient)
                .build()
    }

    val eddieApi by lazy {
        retrofit.create(EddiePlayerApi::class.java)
    }
}
