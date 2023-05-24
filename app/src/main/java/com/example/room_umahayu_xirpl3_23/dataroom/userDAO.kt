package com.example.room_umahayu_xirpl3_23.dataroom

import androidx.room.*

@Dao
interface userDAO {

    //Menampilkan data
    @Query("SELECT * FROM tbuser")
    fun getAll():List<User>

    //Menambahkan data
    @Insert
    fun insertData(user: User)

    //Menghapus data
    @Delete
    fun deleteData(user: User)

    //Mengubah data
    @Update
    fun updateData(user: User)
}