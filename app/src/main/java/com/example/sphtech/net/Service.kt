package com.example.sphtech.net

import android.content.Context
import com.example.sphtech.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

class Service(val context: Context) {
    companion object {
        const val connectionTimeOut: Long = 120
        const val writeTimeOut: Long = 120
        const val readTimeOut: Long = 120
        const val cacheSize: Long = 10 * 1024 * 1024
    }

    private var converterFactory: Converter.Factory = MoshiConverterFactory.create(
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    )

    private var client: OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(BasicAuthInterceptor(user = "user", password = "password"))
        .connectTimeout(connectionTimeOut, TimeUnit.SECONDS)
        .writeTimeout(writeTimeOut, TimeUnit.SECONDS)
        .readTimeout(readTimeOut, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private fun generateService(baseUrl: String): Api {
        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
        return retrofit.create(Api::class.java)
    }

    fun getData(callback: Callback<com.example.sphtech.net.Response>) {
        val api = generateService(BuildConfig.BASEURL)
        api.getData("a807b7ab-6cad-4aa6-87d0-e283a7353a0f", 5).enqueue(callback)

    }

    inner class BasicAuthInterceptor(user: String, password: String) : Interceptor {
        private val credentials: String = Credentials.basic(user, password)

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val authenticatedRequest = request.newBuilder()
                .header("Authorization", credentials)
                .header("Content-Type", "application/json")
                .build()
            return chain.proceed(authenticatedRequest)
        }
    }
}