package com.kova700.someonesdiary.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*작성자 추가*/
@Parcelize
data class DiaryListItem(
    val id: Int,
    val imgUrl: String,
    val title: String,
    val createdDate: String
) :Parcelable