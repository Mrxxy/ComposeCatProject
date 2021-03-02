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

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.teal200

@Composable
fun DetailPage(catBean: CatBean) {
    Column(
        modifier = Modifier
            .background(gray)
            .fillMaxSize()
            .verticalScroll(ScrollState(0)),
    ) {
        Box(
            Modifier
                .background(purple200)
                .clip(shape = RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, bottom = 40.dp)
            ) {
                Image(
                    painter = painterResource(id = catBean.avatar),
                    contentDescription = "avatar",
                    modifier = Modifier
                        .height(140.dp)
                        .width(140.dp)
                        .clip(shape = CircleShape)
                        .background(color = teal200),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = catBean.name, style = MaterialTheme.typography.h3)
            }
        }
        Column(Modifier.padding(16.dp, 8.dp)) {
            Text(
                "Description: ${catBean.desc}",
                style = MaterialTheme.typography.h4
            )
            Spacer(Modifier.height(20.dp))
            ProvideTextStyle(MaterialTheme.typography.h5) {
                Text("Age: ${catBean.age}")
                Text("Color: ${catBean.color}")
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    DetailPage(CatBean(R.drawable.cat_face_4, "Jim", "this content show the cat description", 1))
}
