package com.example.myapplicationlibrary

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplicationlibrary.ui.theme.MyApplicationLibraryTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationLibraryTheme {
                Surface {
                    BookList(activity = this@MainActivity)
                }
            }
        }
    }

    companion object {
        val exampleBooks = listOf(
            Book(
                id = 1,
                title = "The Great Gatsby",
                author = "F. Scott Fitzgerald",
                pageCount = 180,
                imageResId = R.drawable.book1,
                websiteUrl = "https://www.amazon.com/dp/B074T5ZHP7/ref=sspa_dk_detail_1?psc=1&pd_rd_i=B074T5ZHP7&pd_rd_w=4CKkF&content-id=amzn1.sym.eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_p=eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_r=ZNTP80FCH8ZBW95074WN&pd_rd_wg=CWa18&pd_rd_r=cf05daf1-c017-4ce0-be0b-cfb0e450578e&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWw"
            ),
            Book(
                id = 2,
                title = "To Kill a Mockingbird",
                author = "Harper Lee",
                pageCount = 281,
                imageResId = R.drawable.book2,
                websiteUrl = "https://www.amazon.com/dp/B0BXFMGPRG/ref=sspa_dk_detail_0?psc=1&pd_rd_i=B0BXFMGPRG&pd_rd_w=3ru1E&content-id=amzn1.sym.eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_p=eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_r=9D1F29HGPTR8Z207NCDY&pd_rd_wg=TBoCp&pd_rd_r=6f67bd65-c6d1-4836-b8eb-a76a089b506d&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWw"
            ),
            Book(
                id = 3,
                title = "1984",
                author = "George Orwell",
                pageCount = 328,
                imageResId = R.drawable.book3,
                websiteUrl = "https://www.amazon.com/dp/B094137XVG/ref=sspa_dk_detail_0?psc=1&pd_rd_i=B094137XVG&pd_rd_w=qvSIf&content-id=amzn1.sym.eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_p=eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_r=59WANBMNEDXTGHAS4PW5&pd_rd_wg=tQwt0&pd_rd_r=bb323828-28c1-4a53-8b9b-7fc8f94a4121&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWw"
            ),
            Book(
                id = 4,
                title = "Pride and Prejudice",
                author = "Jane Austen",
                pageCount = 279,
                imageResId = R.drawable.book4,
                websiteUrl = "https://www.amazon.com/dp/B0D2S2YZ83/ref=sspa_dk_detail_1?psc=1&pd_rd_i=B0D2S2YZ83&pd_rd_w=lNlVJ&content-id=amzn1.sym.eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_p=eb7c1ac5-7c51-4df5-ba34-ca810f1f119a&pf_rd_r=GBSK9M30JZD5WH3196PS&pd_rd_wg=h3Zlj&pd_rd_r=a378bb8d-5832-4308-ba2f-6869f1c26db1&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWw"
            ),
            Book(
                id = 5,
                title = "The Catcher in the Rye",
                author = "J.D. Salinger",
                pageCount = 214,
                imageResId = R.drawable.book5,
                websiteUrl = "https://www.amazon.com/Time-Management-Solution-Productivity-Work-Life-ebook/dp/B0BFJDX3PM/ref=sr_1_7_sspa?crid=3IY8NP2A7HBPN&dib=eyJ2IjoiMSJ9.sQ1-fvuM9pHQPA9658RSE0l3nB-zrrOVJd5n3Ht6Yc0xKHMrM5K3IzPUxDNKjms-elwhCkGXWSZJtM7RmlBFCSsCeBCJrX4k5JHkX12usS1tHidGmIPRzZK2wW8wRGwnxUBHxqOmfi-a2qGLLISYoph1LAxNnDAnu2Wft2cw2icSZfFh4QejSeeQl2vTGSjUmwlBMnXObElHqiXoDrsjd4-p4mMiXE_b0qKxaOuzlQs.FOPuToFZKn_fxAvT8TdXxmM4qV5vzaBKAf40_X4IHdg&dib_tag=se&keywords=time+management&qid=1716797119&s=digital-text&sprefix=the+time+mana%2Cdigital-text%2C236&sr=1-7-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9tdGY&psc=1"
            ),
            Book(
                id = 6,
                title = "The Hobbit",
                author = "J.R.R. Tolkien",
                pageCount = 310,
                imageResId = R.drawable.book6,
                websiteUrl = "https://www.amazon.com/dp/B0BQJVDYS3/ref=sspa_dk_detail_right_aax_0?psc=1&sp_csd=d2lkZ2V0TmFtZT1zcF9kZXRhaWxfcmlnaHRfc2hhcmVk"
            ),
            Book(
                id = 7,
                title = "Moby-Dick",
                author = "Herman Melville",
                pageCount = 635,
                imageResId = R.drawable.book7,
                websiteUrl = ""
            ),
            Book(
                id = 8,
                title = "War and Peace",
                author = "Leo Tolstoy",
                pageCount = 1225,
                imageResId = R.drawable.book8,
                websiteUrl = "https://www.amazon.com/Change-Management-that-Sticks-Buy-ebook/dp/B0BTTXSHV2/ref=sr_1_2_sspa?crid=1ZDYWNW8HF6AY&dib=eyJ2IjoiMSJ9.c8JnDJC0XEtOa4Q1YQDKTLD8sh7XRg4ENwbM61RVhoTkl4H1DKi-gyUdgPSAH0EptScOkVoN2oAepEJg2CR6ddZTL1SG6U50f6VC1sBj6GPh6nw1DPIMM_Licjxevmc5eXZ_U-InRfdufMUQufRgE1X-Iz3rmOiElPSsqJUMLhyNoJlSS2EbkVJFhhstoTxBzyvO5ckw4wu9sPhAU7nP_zP6G-qahUZYYGHTxMNHWK8.RGOIqLhgi7XFW0lkuid2GzETXP42IMMQVpjd3rDwQKA&dib_tag=se&keywords=change+management&qid=1716797172&s=digital-text&sprefix=change+mana%2Cdigital-text%2C195&sr=1-2-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1"
            ),
            Book(
                id = 9,
                title = "Crime and Punishment",
                author = "Fyodor Dostoevsky",
                pageCount = 671,
                imageResId = R.drawable.book9,
                websiteUrl = "https://www.amazon.com/Book-Change-Richard-Carson-ebook/dp/B0C37VP3GS/ref=sr_1_7?crid=114NUJ0Z8QYHI&dib=eyJ2IjoiMSJ9.YvtrNYlf5nBZs7z-euSKAFCXtYTLu82q4RilVp8W4jRiNavRq5q3ZS-1ghZgkCzSmbji02pqUJPbZRp6JJDxQzkgv0wwT6iCmHwjn6lHPElNEBQlbfjlzqGinnZfu8yhOMgqrQWBaHyh6JM9bJZvWYlq5xPljmGQkp1FMAO0vZ-WNRIjODgUpsCqNLuQCGEurH5QtYTznWAtx13580E_RvNPrPQ44pJvFMlTMKNys6c.g_Xn2KYmHt-U8bCKeMfTfE-CSVXoUHNbCTQmScISjJk&dib_tag=se&keywords=the+book+of+change&qid=1716797225&s=digital-text&sprefix=the+book+of+change%2Cdigital-text%2C195&sr=1-7"
            ),
            Book(
                id = 10,
                title = "The Brothers Karamazov",
                author = "Fyodor Dostoevsky",
                pageCount = 824,
                imageResId = R.drawable.book10,
                websiteUrl = "https://www.amazon.com/Stifled-Where-Good-Leaders-Wrong-ebook/dp/B09H535N7R/ref=sr_1_1?crid=FXVN2W8P3UYL&dib=eyJ2IjoiMSJ9.RrIjax01mOxxKAj3TPZC8EOlU7Y4W_OutdFkNcgyYsGc-OJKavatC7122vZ1sDrRBCeVuJBLFOGXFhSFEKAdQRWOPf8tp_F69Xafm7SS8tn0QDMhIv07xAeCy3w_gGYyXN01LA1PhBntxFyb0M1527ke7aBFbtLj8d-mDm90FCd4WzppKO4LWAhGAKDvGxKeqW049D4UxNnz5mA9GUxPjdI_OCb-n4cCdcz34gDYA4I.YFPzVNzGoUg8Bdy6cxDGibX3Hwl2ebJtbY9amNd8Ubk&dib_tag=se&keywords=stifled&qid=1716797275&s=digital-text&sprefix=stile%2Cdigital-text%2C169&sr=1-1"
            )
        )
    }


    @Composable
    fun BookList(activity: ComponentActivity) {
        val books = exampleBooks.map { book ->
            book.copy(isFavorite = PreferencesUtil.isFavorite(activity, book.id))
        }
        LazyColumn {
            items(books) { book ->
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
                            text = "Title: ${book.title}",
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Text(
                            text = "Author: ${book.author}",
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Text(
                            text = "Pages: ${book.pageCount}",
                            modifier = Modifier.padding(start = 10.dp)
                        )
                        Row(
                            modifier = Modifier.padding(
                                start = 10.dp,
                                bottom = 10.dp
                            )
                        ) {
                            val context = LocalContext.current
                            Button(
                                onClick = {
                                    val intent =
                                        Intent(activity, BookDetailActivity::class.java).apply {
                                            putExtra("bookImageResId", book.imageResId)
                                            putExtra("bookTitle", book.title)
                                            putExtra("bookAuthor", book.author)
                                            putExtra("bookPageCount", book.pageCount)
                                            putExtra("bookWebsiteUrl", book.websiteUrl)
                                        }
                                    activity.startActivity(intent)
                                },
                                modifier = Modifier.padding(end = 10.dp)
                            ) {
                                Text(text = "More")
                            }

                            BookFavorite(book = book, activity = activity)
                        }
                    }
                }
            }
        }

        IconButton(
            onClick = {
                val intent = Intent(activity, StartActivity::class.java)
                activity.startActivity(intent)
            }
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }

        Button(
            onClick = {
                val intent = Intent(activity, FavoriteBooksActivity::class.java)
                activity.startActivity(intent)
            },
            modifier = Modifier.padding(start = 320.dp)
        ) {
            Text(text = "Fav")
        }
    }

    @Composable
    fun BookFavorite(book: Book, activity: ComponentActivity) {
        var isFavorite by remember { mutableStateOf(book.isFavorite) }
        IconButton(onClick = {
            isFavorite = !isFavorite
            book.isFavorite = isFavorite
            PreferencesUtil.saveFavoriteStatus(activity, book.id, isFavorite)
        }) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                tint = if (isFavorite) Color.Red else Color.Gray
            )
        }
    }
}




