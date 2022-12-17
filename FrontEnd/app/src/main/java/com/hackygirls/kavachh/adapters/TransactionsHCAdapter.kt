package com.hackygirls.kavachh.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.dataClass.Trnsactns
import com.hackygirls.kavachh.dataClass.recenctTrans
import com.hackygirls.kavachh.databinding.TransactionsBinding

class TransactionsHCAdapter(val postlist: ArrayList<recenctTrans>) :
    RecyclerView.Adapter<TransactionsHCAdapter.PostviewHolder>()  {

    class PostviewHolder(val binding: TransactionsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionsHCAdapter.PostviewHolder {
        return PostviewHolder(
            TransactionsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: TransactionsHCAdapter.PostviewHolder, position: Int) {
       holder.binding.name.text = postlist[position].recipient_id__username
        holder.binding.srname.text = postlist[position].timestamp
        holder.binding.amount.text = postlist[position].transaction_amount.toString()
        holder.binding.image.text = postlist[position].letter

    }

    override fun getItemCount(): Int {
        return postlist.size
    }

}