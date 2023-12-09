package com.kova700.someonesdiary.util

import com.kova700.someonesdiary.data.DiaryListItem

fun getDummyList(): MutableList<DiaryListItem> {
    val imgUrlList = listOf(
        "https://images.unsplash.com/photo-1598113422828-d1b1796ed154?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1699428489816-fe5008f4f200?q=80&w=1335&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1596592092169-b3f84d01fd76?q=80&w=1335&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1693677769702-94d161717c19?q=80&w=1180&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1652292107840-068826a55369?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1664235640662-39f242974e9b?q=80&w=1170&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1572268045391-2e8511692aa5?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1598762884254-a7145315c5d7?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1700284923285-90d6fe468920?q=80&w=1321&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        "https://images.unsplash.com/photo-1657366123794-dcff74c6c4c9?q=80&w=1287&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    )
    val titleList = listOf(
        "가족들과 여행을 다녀오다.",
        "면접을 보고 왔다.",
        "대구 수성못에 다녀오다.",
        "인생이란 무엇일까 아무리 고민해도 모르겠다.",
        "외할머니 댁에 다녀왔다.",
        "오랜만에 고향 친구들과",
        "소소한 행복",
        "오늘의 발견",
        "좋은 순간, 좋은 사람들과",
        "김장을 하다.",
    )
    val createdDateList = listOf(
        "2023-12-05 09:15",
        "2023-11-15 12:45",
        "2023-10-04 15:30",
        "2023-12-05 18:20",
        "2023-09-05 20:00",
        "2023-04-15 22:45",
        "2023-12-11 14:00",
        "2023-01-05 17:10",
        "2023-12-25 19:40",
        "2023-02-05 23:55"
    )
    val dummyList = MutableList(imgUrlList.size) { num ->
        DiaryListItem(
            id = num,
            imgUrl = imgUrlList[num],
            title = titleList[num],
            createdDate = createdDateList[num]
        )
    }
    return dummyList
}