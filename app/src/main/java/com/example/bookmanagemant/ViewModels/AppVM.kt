package com.example.bookmanagemant.ViewModels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppVM: ViewModel() {
    // var of TextField
    var searchKeyword = mutableStateOf("")
}