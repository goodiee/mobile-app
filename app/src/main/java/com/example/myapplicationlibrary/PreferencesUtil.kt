package com.example.myapplicationlibrary

import android.content.Context
import android.content.SharedPreferences

object PreferencesUtil {

    private const val PREFS_NAME = "book_prefs"
    private const val FAVORITES_KEY = "favorites"

    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveFavoriteStatus(context: Context, bookId: Int, isFavorite: Boolean) {
        val prefs = getSharedPreferences(context)
        val favorites = prefs.getStringSet(FAVORITES_KEY, mutableSetOf())?.toMutableSet() ?: mutableSetOf()
        if (isFavorite) {
            favorites.add(bookId.toString())
        } else {
            favorites.remove(bookId.toString())
        }
        prefs.edit().putStringSet(FAVORITES_KEY, favorites).apply()
    }

    fun isFavorite(context: Context, bookId: Int): Boolean {
        val prefs = getSharedPreferences(context)
        val favorites = prefs.getStringSet(FAVORITES_KEY, emptySet()) ?: emptySet()
        return favorites.contains(bookId.toString())
    }
}
