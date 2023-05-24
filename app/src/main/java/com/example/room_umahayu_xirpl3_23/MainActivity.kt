package com.example.room_umahayu_xirpl3_23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.room_umahayu_xirpl3_23.dataroom.User
import com.example.room_umahayu_xirpl3_23.dataroom.dbuser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Class dbuser untuk memanggil userDao
    // Untuk memanggil db.
    private val db by lazy { dbuser(this) }

    private lateinit var inputId: EditText
    private lateinit var inputNama: EditText
    private lateinit var inputJK: EditText
    private lateinit var simpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputId= findViewById(R.id.idUser)
        inputNama= findViewById(R.id.namaUser)
        inputJK= findViewById(R.id.jkUser)
        simpan= findViewById(R.id.btnSimpan)

        simpanData()
    }
    fun simpanData(){
        simpan.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.userDao().insertData(
                // userDao mengikuti class dbuser
                // insertData mengikuti class userDAO
                    User(
                        inputId.text.toString(),
                        inputNama.text.toString(),
                        inputJK.text.toString()
                    )
                )
            }
            // Menampilkan data
            startActivity(Intent(applicationContext,DataActivity::class.java))
        }
    }
}