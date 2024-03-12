package com.example.apiproject.dataClassesLeague

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataLeague(val users: List<UsersLeague>) : Parcelable
