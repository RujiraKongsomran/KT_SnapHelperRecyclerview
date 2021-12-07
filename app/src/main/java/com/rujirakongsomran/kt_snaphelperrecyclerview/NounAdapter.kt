package com.rujirakongsomran.kt_snaphelperrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NounAdapter(private val nounList: List<NounItem>) : RecyclerView.Adapter<NounAdapter.NounViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NounViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.noun_item,
            parent, false
        )
        return NounViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NounViewHolder, position: Int) {
        val currentItem = nounList[position]

        holder.iv_logo.setImageResource(currentItem.imageResource)
        holder.tv_1.text = currentItem.text1
        holder.tv_2.text = currentItem.text2
    }

    override fun getItemCount() = nounList.size

    class NounViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv_logo: ImageView = itemView.findViewById(R.id.iv_logo)
        val tv_1: TextView = itemView.findViewById(R.id.tv_1)
        val tv_2: TextView = itemView.findViewById(R.id.tv_2)
    }
}