package com.example.bookmanagemant.nerwork

import android.util.Log

class BookApiRepository {
    private val apiService = RetrofitInstance.ApiService

    suspend fun searchBooks(query: String) : BooksInfoDataModel {
        Log.d("methodTest", "searchBooks(repository): $query")
        return apiService.searchBooks(query)
    }
}