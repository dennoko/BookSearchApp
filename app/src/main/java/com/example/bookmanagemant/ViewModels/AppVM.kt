package com.example.bookmanagemant.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.bookmanagemant.nerwork.BookItem

class AppVM: ViewModel() {
    // var of TextField
    var searchKeyword = mutableStateOf("")

    // ui state of display detail
    var isDisplayDetail = mutableStateOf(false)

    // save bookItem
    var bookItem: BookItem? = null
}