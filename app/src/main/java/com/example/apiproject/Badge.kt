package com.example.apiproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Badge(val id: String,
    val label: String,
    val ts: String?) : Parcelable
