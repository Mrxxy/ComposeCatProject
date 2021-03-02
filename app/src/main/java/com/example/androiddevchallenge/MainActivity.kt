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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
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
import com.example.androiddevchallenge.compose.CatBean
import com.example.androiddevchallenge.compose.CatItemView
import com.example.androiddevchallenge.ui.theme.gray


class MainActivity : AppCompatActivity() {
    private val avatarList = arrayListOf(
        R.drawable.cat_face_1,
        R.drawable.cat_face_2,
        R.drawable.cat_face_3,
        R.drawable.cat_face_4,
        R.drawable.cat_face_5,
        R.drawable.cat_face_6,
        R.drawable.cat_face_7,
        R.drawable.cat_face_2,
        R.drawable.cat_face_4,
        R.drawable.cat_face_6,
        R.drawable.cat_face_3,
        R.drawable.cat_face_1,
        R.drawable.cat_face_2,
        R.drawable.cat_face_7,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nameList = resources.getStringArray(R.array.name_list)
        val descList = resources.getStringArray(R.array.desc_list)
        val catList =
            (0 until avatarList.size).map { index ->
                CatBean(
                    avatarList[index],
                    nameList[(nameList.indices).random()],
                    descList[(descList.indices).random()],
                    (0 until 6).random()
                )
            }.toList()
        setContent {
            MyApp(catList)
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(catList: List<CatBean>) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Pet Home") })
        },
        content = { ListContent(catList = catList) }
    )
}

@Composable
fun ListContent(catList: List<CatBean>) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.background(gray)
    ) {
        items(catList) { cat ->
            CatItemView(catBean = cat)
        }
    }
}

