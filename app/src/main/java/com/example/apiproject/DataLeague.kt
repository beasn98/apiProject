package com.example.apiproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataLeague(val users: List<UsersLeague>) : Parcelable
