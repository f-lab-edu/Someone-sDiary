package com.kova700.someonesdiary.util

import android.content.Context
import android.util.DisplayMetrics

fun Context.getDeviceWidthPixels(): Int {
    val contextResources = applicationContext.resources
    val displayMetrics: DisplayMetrics = contextResources.displayMetrics
    return displayMetrics.widthPixels
}

fun Context.getDeviceHeightPixels(): Int {
    val contextResources = applicationContext.resources
    val displayMetrics: DisplayMetrics = contextResources.displayMetrics
    return displayMetrics.heightPixels
}