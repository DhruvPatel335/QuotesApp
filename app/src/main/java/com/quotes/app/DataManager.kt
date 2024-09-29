package com.quotes.app

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.quotes.app.models.QuotesModel

object DataManager {
    var data = emptyArray<QuotesModel>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<QuotesModel>::class.java)
        isDataLoaded.value = true
    }
}