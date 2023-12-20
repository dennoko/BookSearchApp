package com.example.bookmanagemant.nerwork

import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("books/v1/volumes")
    suspend fun searchBooks(
        @Query("q") query: String,
    ) : BooksInfoDataModel
}