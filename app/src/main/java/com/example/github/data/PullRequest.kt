package com.example.github.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PullRequest(
    val number: String,
    val title: String,
    val description: String
) : Parcelable