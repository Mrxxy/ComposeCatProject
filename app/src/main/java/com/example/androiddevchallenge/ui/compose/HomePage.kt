package com.example.androiddevchallenge.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.MainViewModel
import com.example.androiddevchallenge.compose.CatItemView
import com.example.androiddevchallenge.ui.theme.gray

@Composable
fun HomePage() {
    val viewModel: MainViewModel = viewModel()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = if (viewModel.currentCat == null) "Pet Home" else viewModel.currentCat!!.name) })
        },
        content = {
            if (viewModel.currentCat == null) {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.background(gray)
                ) {
                    items(viewModel.catList.value) { cat ->
                        CatItemView(catBean = cat, Modifier.clickable {
                            viewModel.currentCat = cat
                        })
                    }
                }
            } else {
                viewModel.currentCat?.let { DetailPage(catBean = it) }
            }
        }
    )
}