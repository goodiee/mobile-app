package com.example.myapplicationlibrary

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplicationlibrary.ui.theme.MyApplicationLibraryTheme

class FavoriteBooksActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        setContent {
            MyApplicationLibraryTheme {
                Surface {
                    FavoriteBookList(activity = this@FavoriteBooksActivity)
                }
            }
        }
    }

    @Composable
    fun FavoriteBookList(activity: ComponentActivity) {
        val favoriteBooks = MainActivity.exampleBooks.filter { book ->
            PreferencesUtil.isFavorite(activity, book.id)
        }

        var commentText by remember { mutableStateOf("") }
        var comments by remember { mutableStateOf(loadComments()) }
        var bottomCommentText by remember { mutableStateOf("") }

        LazyColumn {
            items(favoriteBooks) { book ->
                Row(
                    modifier = Modifier.padding(top = 20.dp, bottom = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier.padding(start = 20.dp),
                        painter = painterResource(id = book.imageResId),
                        contentDescription = book.title
                    )
                    Column {
                        Text(
                            text = book.title,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }

            // Single text input and post button at the bottom
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextField(
                        value = bottomCommentText,
                        onValueChange = { bottomCommentText = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Share Your Thoughts") }
                    )
                    Button(
                        onClick = {
                            addComment(bottomCommentText)
                            bottomCommentText = ""
                            comments = loadComments()
                        },
                        modifier = Modifier.padding(start = 10.dp)
                    ) {
                        Text("Post")
                    }
                }
            }

            items(comments) { comment ->
                Text(text = comment, modifier = Modifier.padding(10.dp))
            }
        }

        IconButton(
            onClick = {
                val intent = Intent(activity, MainActivity::class.java)
                activity.startActivity(intent)
            }
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
    }

    private fun loadComments(): List<String> {
        val savedComments = sharedPreferences.getStringSet("comments", emptySet()) ?: emptySet()
        return savedComments.toList()
    }

    private fun addComment(newComment: String) {
        val currentComments = loadComments().toMutableSet()
        currentComments.add(newComment)
        sharedPreferences.edit().putStringSet("comments", currentComments).apply()
    }
}
