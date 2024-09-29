package com.quotes.app

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.quotes.app.models.QuotesModel


@Composable
fun QuoteList(data: Array<QuotesModel>, onClick: () -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuotesListItem(quote = it) {
                onClick()
            }
        }
    })
}