package com.hackygirls.kavachh.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hackygirls.kavachh.R
import com.hackygirls.kavachh.dataClass.Suspect
import com.hackygirls.kavachh.dataClass.SuspectList
import com.hackygirls.kavachh.dataClass.SuspectX
import org.json.JSONObject.NULL
import retrofit2.Response

class SuspectAdapter :  RecyclerView.Adapter<SuspectAdapter.SuspectViewHolder>() {

    var suspect = ArrayList<SuspectX>()
    class SuspectViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name : TextView = itemView.findViewById(R.id.name)
        val time : TextView = itemView.findViewById(R.id.srname)
        val amount : TextView = itemView.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuspectAdapter.SuspectViewHolder {
        return SuspectViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.suspect, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuspectAdapter.SuspectViewHolder, position: Int) {
       val suspec = suspect[position]

        holder.name.text = suspec.borrower__username.toString()
        holder.time.text = suspec.timestamp.toString()
        if(holder.amount.text != NULL) {
            holder.amount.text = suspec.amount.toString()
            Log.d("null btao", "${holder.amount.text}")
        }
        else{
            holder.amount.text = "0"
            Log.d("null btao", "${holder.amount.text}")
        }

    }

    override fun getItemCount(): Int {
        return suspect.size
    }

    @JvmName("setSuspct")
    fun setSuspct(suspect: ArrayList<SuspectX>) {
        this.suspect.clear()
        this.suspect = suspect
        notifyDataSetChanged()
    }


}
