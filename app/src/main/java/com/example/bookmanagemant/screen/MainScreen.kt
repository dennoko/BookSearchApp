package com.example.bookmanagemant.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.bookmanagemant.ViewModels.ApiVM
import com.example.bookmanagemant.ViewModels.AppVM
import com.example.bookmanagemant.ui_components.BookDialog
import com.example.bookmanagemant.ui_components.BookTitleCard
import com.example.bookmanagemant.ui_components.TitleTxt

@Composable
fun MainScreen(vm: ApiVM, appvm: AppVM) {
    Box {
        if (appvm.isDisplayDetail.value) {
            BookDialog(bookItem = appvm.bookItem!!, isDisplayDetail = appvm.isDisplayDetail.value) {
                appvm.isDisplayDetail.value = false
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TitleTxt()
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Add a keyword to search for books.",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            BasicTextField(
                value = appvm.searchKeyword.value,
                onValueChange = {
                    appvm.searchKeyword.value = it
                },
                Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                    .border(2.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp))
                    .padding(8.dp),
                singleLine = true, // ここに書かないとitでエラーが出る. なぜ?
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { vm.searchBooks(appvm.searchKeyword.value) },
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primary ,shape = RoundedCornerShape(8.dp))
            ) {
                Text(
                    text = "Search",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            val booksInfo by vm.booksInfo.collectAsState()

            booksInfo?.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ) {
                    it.items.forEach { item ->
                        BookTitleCard(bookItem = item) {
                            appvm.bookItem = item
                            appvm.isDisplayDetail.value = true
                        }
                    }
                }
            }
        }
    }
}