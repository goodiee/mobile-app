package com.example.myapplicationlibrary

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.example.myapplicationlibrary.ui.theme.MyApplicationLibraryTheme

class StartActivity<Painter> : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationLibraryTheme {
                Surface {
                    StartScreen()
                }
            }
        }
    }

    @Composable
    fun StartScreen() {
        val context = LocalContext.current
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            val backgroundImage: androidx.compose.ui.graphics.painter.Painter = painterResource(id = R.drawable.library2)

            Image(
                painter = backgroundImage,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Library Book",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(
                    onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Start Searching")
                }
            }
        }
    }
}