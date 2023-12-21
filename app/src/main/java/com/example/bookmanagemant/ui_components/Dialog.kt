package com.example.bookmanagemant.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.bookmanagemant.nerwork.BookItem

@Composable
fun BookDialog(bookItem: BookItem, isDisplayDetail: Boolean, onDismissRequest: () -> Unit) {
    if (isDisplayDetail) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                    .border(1.dp, MaterialTheme.colorScheme.onSurface)
            ) {
                Column {
                    // title and image into Row
                }
            }
        }
    }
}