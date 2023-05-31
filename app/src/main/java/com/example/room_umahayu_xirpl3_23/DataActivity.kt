package com.example.room_umahayu_xirpl3_23

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room_umahayu_xirpl3_23.dataroom.User
import com.example.room_umahayu_xirpl3_23.dataroom.dbuser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DataActivity : AppCompatActivity() {

    private lateinit var activityAdapter: AdapterActivity
    private lateinit var recyclerView: RecyclerView
    private val db by lazy { dbuser(this) }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val actionBar = supportActionBar
        if (actionBar !=null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        recyclerView = findViewById(R.id.rv_room)
        activityAdapter =
            AdapterActivity(arrayListOf(), object : AdapterActivity.onAdapterListener {
                override fun onClick(user: User) {
                    startActivity(
                        Intent(
                            applicationContext, DataActivity::class.java
                        ).putExtra("Id", user.idUser)
                    )
                }
            })

        recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = activityAdapter
        }
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.userDao().getAll()
            withContext(Dispatchers.Main){
                activityAdapter.setData(data)
            }
        }
    }
}