package com.example.smtlabstask.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smtlabstask.R
import com.example.smtlabstask.model.PhotosData

class RecyclerVAdapter(private var mList: ArrayList<PhotosData>) : RecyclerView.Adapter<RecyclerVAdapter.ViewHolder>() {

    private lateinit var context : Context


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]

        for (obj in ItemsViewModel){
            Log.d("name!",obj.title )
            holder.nametextV.text = obj.title
            Glide.with(context).load(obj.url).into(holder.imageV)

        }


    }


    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val nametextV: TextView = itemView.findViewById(R.id.title)
        val imageV: ImageView = itemView.findViewById(R.id.ImageVData)
    }


}
