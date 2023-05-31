package com.example.room_umahayu_xirpl3_23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room_umahayu_xirpl3_23.dataroom.User

class AdapterActivity(private val list: ArrayList<User>, private val listener: onAdapterListener):
    RecyclerView.Adapter<AdapterActivity.ViewHolder>(){
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nis = itemView.findViewById<TextView>(R.id.tv_nis)
        val nama = itemView.findViewById<TextView>(R.id.tv_nama)
    }

    //menampilkan tampilan adapter.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.activity_adapter, parent, false
            )
        )
    }

    //berisi data apasaja yang akan dimunculkan
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = list[position]
        holder.nis.text = user.idUser.toString()
        holder.nama.text = user.namaUser.toString()
        //supaya id bisa di clik, blh ada blh tdk
        holder.nis.setOnClickListener{
            listener.onClick(user)
        }
    }

    //membaca seberapa banyak data yang ada paa RV
    override fun getItemCount() = list.size

    fun setData (listData: List<User>){
        list.clear()
        list.addAll(listData)
        notifyDataSetChanged()
    }
    interface onAdapterListener{
        fun onClick(
            user: User
        )
    }
}


