package com.example.androiddevchallenge

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.compose.CatBean

class MainViewModel : ViewModel() {
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
    private val nameList = listOf(
        "Tom", "Jerry", "Frank", "Cook", "Sherry", "Jessica", "LuLu", "Clear", "Kiss", "Super"
    )
    private val colorList = listOf(
        "Yellow", "Gray", "Brown", "Black"
    )
    private val descList = listOf(
        "He is from China and is a five-month-old baby",
        "When we picked him up, he was playing with a puppy",
        "His master discarded him, we picked it back from the garbage dump",
        "Her mother gave birth to a brother, which the host family could not affor",
        "She is very obedient and clingy",
        "I fell in love with him when I first met him",
        "He is old and needs to find someone to take care of him",
    )
    var currentCat: CatBean? by mutableStateOf(null)
    var catList: MutableState<List<CatBean>>

    init {
        val catData =
            (0 until avatarList.size).map { index ->
                CatBean(
                    avatarList[index],
                    nameList[(nameList.indices).random()],
                    descList[(descList.indices).random()],
                    (0 until 6).random(),
                    colorList[(colorList.indices).random()],
                )
            }.toList()
        catList = mutableStateOf(catData)
    }
}