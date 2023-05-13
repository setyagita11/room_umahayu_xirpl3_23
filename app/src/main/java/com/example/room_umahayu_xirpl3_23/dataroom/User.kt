package com.example.room_umahayu_xirpl3_23.dataroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tbUser")
data class User(
    @PrimaryKey
    @ColumnInfo("ID_USER")
    val idUser : String,
    @ColumnInfo("NAMA_USER")
    val namaUser : String?,
    @ColumnInfo("JENISKELAMIN_USER")
    val jekelUser : String
)
