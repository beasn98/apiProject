package com.example.apiproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayerLeague(val data: DataLeague) : Parcelable
