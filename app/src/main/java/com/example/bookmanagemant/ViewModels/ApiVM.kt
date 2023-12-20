package com.example.bookmanagemant.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmanagemant.nerwork.BookApiRepository
import com.example.bookmanagemant.nerwork.BooksInfoDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ApiVM: ViewModel() {
    // Initialize the Repository
    private val repository = BookApiRepository()

    // read-only access to the data
    private val _booksInfoDataModel = MutableStateFlow<BooksInfoDataModel?>(null)
    val booksInfo: StateFlow<BooksInfoDataModel?> = _booksInfoDataModel.asStateFlow()

    fun searchBooks(keyword: String) {
        Log.d("methodTest", "searchBooks: $keyword")
        viewModelScope.launch {
            try {
                Log.d("methodTest", "searchBooks: try")
                _booksInfoDataModel.value = repository.searchBooks(keyword)
            } catch (e: Exception) {
                Log.d("methodTest", "searchBooks: ${e.message} ${e.cause}")
            }
        }
    }
}