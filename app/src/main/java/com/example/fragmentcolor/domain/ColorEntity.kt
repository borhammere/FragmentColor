package com.example.fragmentcolor.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ColorEntity(
    val id: String,
    val name: String,
    val color: Int
) : Parcelable