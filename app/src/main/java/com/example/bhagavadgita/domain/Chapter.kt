package com.example.bhagavadgita.domain

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Chapter(
    val id:Int,
    val title:String,
    var path:String?) :Parcelable

