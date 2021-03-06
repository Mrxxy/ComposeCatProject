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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.purple200

@Composable
fun CatItemView(catBean: CatBean, modifier: Modifier) {
    Card(shape = RoundedCornerShape(10.dp), modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = catBean.avatar),
                contentDescription = "avatar",
                modifier = Modifier
                    .padding(15.dp)
                    .height(80.dp)
                    .width(80.dp)
                    .clip(shape = CircleShape)
                    .background(color = purple200),
                contentScale = ContentScale.Inside
            )
            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(vertical = 20.dp)
                    .padding(end = 15.dp)
            ) {
                Text(text = catBean.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = catBean.desc,
                    style = MaterialTheme.typography.body2,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    val cat = CatBean(R.drawable.cat_face_1, "Shayne", "from China", 3)
    CatItemView(cat, modifier = Modifier.fillMaxWidth())
}

data class CatBean(
    @DrawableRes var avatar: Int,
    var name: String,
    var desc: String,
    var age: Int,
    var color: String = "Yellow"
)
