package com.deepak.nasaapp.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageProperty(

    val id: Int,
    val title: String,
    val explanation: String,
    @Json(name = "url")
    var url: String,
    val copyright: String,
    val date:String): Parcelable