package com.hackygirls.kavachh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.dataClass.Brrwrs
import com.hackygirls.kavachh.dataClass.recenctTrans

class BorrowersAdapter (private val mList: List<Brrwrs>)  : RecyclerView.Adapter<BorrowersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.borrowers, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.textView.text = ItemsViewModel.name
        holder.textView2.text = ItemsViewModel.username
        holder.textView3.text = ItemsViewModel.title
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.name)
        val textView2: TextView = itemView.findViewById(R.id.srname)
        val textView3: TextView = itemView.findViewById(R.id.image)

    }
}