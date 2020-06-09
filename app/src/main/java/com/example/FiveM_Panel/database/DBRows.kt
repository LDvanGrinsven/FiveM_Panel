package com.example.FiveM_Panel.database

import android.os.Parcelable
import android.widget.Button
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


@Parcelize
data class DBRows(
    var useridentifier: String,
    var firstname: String,
    var lastname: String,
    var dateofbirth: String,
    var height: Int,
    var group: String

): Parcelable