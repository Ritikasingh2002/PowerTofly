package com.hackygirls.kavachh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.dataClass.recenctTrans
import kotlinx.android.synthetic.main.transactions.view.*

class RecentTransacAdapter : RecyclerView.Adapter<RecentTransacAdapter.MyViewHolder>() {
    private var myList = emptyList<recenctTrans>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.transactions, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.itemView.name.text = myList[position].recipient_id__username.toString()
        holder.itemView.srname.text = myList[position].timestamp.toString()
        holder.itemView.image.text = myList[position].recipient_id__username.toString()
    }

    override fun getItemCount(): Int {
        return myList.size
    }
    fun setData(newList: List<recenctTrans>){
        myList = newList
        notifyDataSetChanged()
    }
}