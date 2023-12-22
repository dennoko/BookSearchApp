package com.example.bookmanagemant.ui_components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.bookmanagemant.nerwork.BookItem

@Composable
fun BookDialog(bookItem: BookItem, isDisplayDetail: Boolean, onDismissRequest: () -> Unit) {
    if (isDisplayDetail) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 96.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                    .border(1.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(16.dp))
                    .shadow(4.dp)
            ) {
                Log.d("methodTest", "BookDialog: ${bookItem.volumeInfo}")
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    // title
                    Text(
                        text = bookItem.volumeInfo.title,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(8.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 3,
                    )

                    // subtitle
                    Text(
                        text = bookItem.volumeInfo.subtitle,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(4.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                    )

                    // author and image into Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Log.d("methodTest", "BookDialog: ${bookItem.volumeInfo.imageLinks.thumbnail}")
                        AsyncImage(
                            model = bookItem.volumeInfo.imageLinks.thumbnail.toUri(),
                            contentDescription = bookItem.volumeInfo.title,
                            modifier = Modifier
                                .size(128.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Column {
                            bookItem.volumeInfo.authors.forEach { author ->
                                Log.d("methodTest", "BookDialog: ${author}")
                                Text(
                                    text = author,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(4.dp),
                                    color = MaterialTheme.colorScheme.onSurface,
                                )
                            }

                            Text(
                                text = bookItem.volumeInfo.publisher,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(4.dp),
                                color = MaterialTheme.colorScheme.onSurface,
                            )
                        }
                    }

                    Text(
                        text = bookItem.volumeInfo.description,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(16.dp),
                        color = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        }
    }
}