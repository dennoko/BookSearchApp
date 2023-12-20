package com.example.bookmanagemant.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bookmanagemant.ViewModels.ApiVM
import com.example.bookmanagemant.ViewModels.AppVM
import com.example.bookmanagemant.ui_components.TitleTxt

@Composable
fun MainScreen(vm: ApiVM, appvm: AppVM) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
        ) {
        TitleTxt()
        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            value = appvm.searchKeyword.value,
            onValueChange = {
            appvm.searchKeyword.value = it
        },
            Modifier
                .background(color = MaterialTheme.colorScheme.surface)
                .border(2.dp, MaterialTheme.colorScheme.primary)
                .padding(8.dp)
            )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { vm.searchBooks(appvm.searchKeyword.value) }
        ) {
            Text(text = "Search")
        }

        val booksInfo by vm.booksInfo.collectAsState()

        booksInfo?.let {
            Text(text = it.items[0].volumeInfo.title)
        }
    }
}