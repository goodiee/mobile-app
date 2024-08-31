package com.example.myapplicationlibrary

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class BookDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val bookId = intent.getIntExtra("bookId", 0)
        val bookImageResId = intent.getIntExtra("bookImageResId", 0)
        val bookTitle = intent.getStringExtra("bookTitle")
        val bookAuthor = intent.getStringExtra("bookAuthor")
        val bookPageCount = intent.getIntExtra("bookPageCount", 0)
        val bookWebsiteUrl = intent.getStringExtra("bookWebsiteUrl") ?: ""

        setContent {
            val book = Book(
                id = bookId,
                imageResId = bookImageResId,
                title = bookTitle ?: "",
                author = bookAuthor ?: "",
                pageCount = bookPageCount,
                websiteUrl = bookWebsiteUrl
            )
            BookDetailScreen(
                activity = this@BookDetailActivity,
                bookImageResId = bookImageResId,
                bookTitle = bookTitle,
                bookAuthor = bookAuthor,
                bookPageCount = bookPageCount,
                book = book
            )
        }
    }
}

@Composable
fun BookDetailScreen(
    activity: ComponentActivity,
    bookImageResId: Int,
    bookTitle: String?,
    bookAuthor: String?,
    bookPageCount: Int,
    book: Book
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReturnToMainActivityButton(activity = activity)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.websiteUrl))
                    activity.startActivity(intent)
                },
            painter = painterResource(id = bookImageResId),
            contentDescription = "Book Image"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = bookTitle ?: "Unknown Title")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Author: ${bookAuthor ?: "Unknown Author"}")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Pages: $bookPageCount")

        Spacer(modifier = Modifier.height(16.dp))
        ShareButton(activity = activity, bookTitle = bookTitle, bookAuthor = bookAuthor)
    }
}

@Composable
fun ShareButton(activity: ComponentActivity, bookTitle: String?, bookAuthor: String?) {
    Button(
        onClick = {
            if (!bookTitle.isNullOrBlank() && !bookAuthor.isNullOrBlank()) {
                shareBook(activity, bookTitle, bookAuthor)
            }
        },
        modifier = Modifier
            .padding(50.dp)
            .width(125.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        )
    ) {
        Text(
            text = "SHARE",
            modifier = Modifier.padding(16.dp)
        )
    }
}


private fun shareBook(activity: ComponentActivity, bookTitle: String?, bookAuthor: String?) {
    val shareIntent = Intent(Intent.ACTION_SEND)
    shareIntent.type = "text/plain"
    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Check out this book!")
    shareIntent.putExtra(Intent.EXTRA_TEXT, "Title: $bookTitle\nAuthor: $bookAuthor")
    activity.startActivity(Intent.createChooser(shareIntent, "Share book details"))
}


@Composable
fun ReturnToMainActivityButton(activity: ComponentActivity) {
    Icon(
        imageVector = Icons.Filled.Clear,
        contentDescription = "Return to Main Activity",
        modifier = Modifier.padding(16.dp).clickable {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    )
}

