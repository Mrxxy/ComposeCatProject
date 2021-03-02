/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
                        CatItemView(
                            catBean = cat,
                            Modifier.clickable {
                                viewModel.currentCat = cat
                            }
                        )
                    }
                }
            } else {
                viewModel.currentCat?.let { DetailPage(catBean = it) }
            }
        }
    )
}
