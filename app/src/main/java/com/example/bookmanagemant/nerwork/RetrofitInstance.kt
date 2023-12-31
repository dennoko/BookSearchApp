package com.example.bookmanagemant.nerwork

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

object RetrofitInstance {
    private const val BASE_URL = "https://www.googleapis.com/"

    private val retrofit: Retrofit by lazy {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType())) // toMediaType is contained in okhttp3. So you need to add okhttp3 dependency in build.gradle.
            .build()
    }

    val ApiService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}