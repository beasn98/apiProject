package com.example.apiproject.dataClassesUser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(val user: User) : Parcelable
