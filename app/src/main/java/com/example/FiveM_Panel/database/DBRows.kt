package com.example.FiveM_Panel.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DBRows(
    var firstname: String,
    var lastname: String,
    var dateofbirth: String,
    var height: Int,
    var group: String

): Parcelable