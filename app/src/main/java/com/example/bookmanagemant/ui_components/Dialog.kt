package com.example.bookmanagemant.ui_components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.net.toUri
import coil.compose.AsyncImage
import com.example.bookmanagemant.nerwork.BookItem
import com.example.bookmanagemant.nerwork.ImageLink
import com.example.bookmanagemant.nerwork.VolumeInfo

@Composable
fun BookDialog(bookItem: BookItem, isDisplayDetail: Boolean, onDismissRequest: () -> Unit) {
    if (isDisplayDetail) {
        Dialog(onDismissRequest = { onDismissRequest() }) {
            Box(
                modifier = Modifier
                    .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                    .border(1.dp, MaterialTheme.colorScheme.onSurface, RoundedCornerShape(16.dp))
                    .shadow(4.dp)
                    .size(300.dp, 500.dp)
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
                        color = Color.Black,
                        maxLines = 3,
                    )

                    // subtitle
                    Text(
                        text = bookItem.volumeInfo.subtitle,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(4.dp),
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Divider()

                    // author and image into Row
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Log.d("methodTest", "BookDialog: ${bookItem.volumeInfo.imageLinks.thumbnail}")
                        AsyncImage(
                            model = bookItem.volumeInfo.imageLinks.thumbnail,
                            contentDescription = bookItem.volumeInfo.title,
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f),
                            contentScale = ContentScale.FillWidth,
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Column(
                            modifier = Modifier
                                .weight(1f)
                        ) {
                            Text(text = "著者",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(2.dp),
                                color = Color.Black,
                            )

                            bookItem.volumeInfo.authors.forEach { author ->
                                Log.d("methodTest", "BookDialog: ${author}")
                                Text(
                                    text = author,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    modifier = Modifier
                                        .padding(4.dp),
                                    color = Color.Black,
                                )
                            }

                            Text(
                                text = "出版社",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(2.dp),
                                color = Color.Black,
                            )

                            Text(
                                text = bookItem.volumeInfo.publisher,
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                modifier = Modifier
                                    .padding(4.dp),
                                color = Color.Black,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Divider()

                    Text(
                        text = bookItem.volumeInfo.description,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.Black,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BookDialogPreview() {
    BookDialog(
        bookItem = BookItem(
            id = "1",
            volumeInfo = VolumeInfo(
                title = "title",
                subtitle = "subtitle",
                authors = listOf("author1", "author2"),
                publisher = "publisher",
                description = "description",
                imageLinks = ImageLink(
                    thumbnail = "http://books.google.com/books/content?id=fJHhEAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
                )
            )
        ),
        isDisplayDetail = true,
        onDismissRequest = {}
    )
}