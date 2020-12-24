package com.example.anggotaapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anggotaapp.Model.getData.DataItem
import com.example.anggotaapp.R
import kotlinx.android.synthetic.main.listitem.view.*

class DataAdapter(val data: List<DataItem>?, val itemClick : OnClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.nama
        holder.nohp.text = item?.nohp
        holder.alamat.text = item?.alamat

        holder.view.setOnClickListener {
            itemClick.detail(item)
        }
    }

    override fun getItemCount(): Int = data?.size?: 0

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val nama = view.nama
        val nohp = view.nohp
        val alamat = view.alamat
    }

    interface OnClickListener {
        fun detail(item: DataItem?)
    }
}