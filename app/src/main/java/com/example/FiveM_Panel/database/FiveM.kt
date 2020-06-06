package com.example.FiveM_Panel.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "fivemdb")
data class FiveM(
    @ColumnInfo(name = "DBname")
    var DBname: String,

    @ColumnInfo(name = "ip")
    var ipaddress: String,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "password")
    var password: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
): Parcelable