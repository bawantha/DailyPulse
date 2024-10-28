package com.bawantha.dailypulse.android

import android.widget.Toolbar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bawantha.dailypulse.Platform

@Composable
fun AboutScreen() {
    Column {
        Toolbar()
        ContentView()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(title = { Text("About")})
}


@Composable
fun ContentView(){
    var items= makeItems()
    LazyColumn (modifier = Modifier.fillMaxSize())
    {
        items(items.size) { index ->
            val item = items[index]
            RowView(item.first, item.second)
        }
    }
}

fun makeItems(): List<Pair<String,String>> {
    val platform=Platform()
    return listOf(
        Pair("OS Name", platform.osName),
        Pair("OS Version", platform.osVersion),
        Pair("Device Version", platform.deviceVersion),
        Pair("Density", platform.density.toString())
    )
}

@Composable
fun RowView(key: String, value: String) {
    Row {
        Text(key)
        Text(value)
    }
}