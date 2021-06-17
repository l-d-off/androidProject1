package com.darf.androidProject1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// является наследником класса, параметр которого потенциально не существует
// при этом, мы этот параметр (Adapter.ViewHolder) определяем в новом классе
// но передаём в базовый
// ЧТО?
class Adapter(private val values: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = values[position]
    }

    override fun getItemCount() = values.size

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null
        var imageView: ImageView? = null

        init {
            textView = itemView.findViewById(R.id.text_list_item)
            imageView = itemView.findViewById(R.id.image_list_item)
        }
    }
}