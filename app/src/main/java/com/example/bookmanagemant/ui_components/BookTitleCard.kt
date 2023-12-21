package com.example.bookmanagemant.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookmanagemant.nerwork.BookItem
import com.example.bookmanagemant.ui.theme.AppTheme

@Composable
fun BookTitleCard(bookItem: BookItem) {
    OutlinedCard(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onSurface,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Text(
            text = bookItem.volumeInfo.title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            minLines = 2,
            maxLines = 2,
            modifier = Modifier
                .padding(4.dp),
            color = MaterialTheme.colorScheme.onSurface,
        )
    }
}

@Preview
@Composable
fun BookTitleCardPreview() {
    AppTheme {
        OutlinedCard(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = "BookTitleCardPreview",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                minLines = 2,
                maxLines = 2,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}
