package com.example.taller4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes

class ItemAdapter(
    context: Context,
    @LayoutRes private val layoutResource: Int,
    private val items: List<Item>
) : ArrayAdapter<Item>(context, layoutResource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(layoutResource, parent, false)

        val item = items[position]

        val titleView = view.findViewById<TextView>(R.id.itemTitle)

        titleView.text = item.titulo

        return view
    }
}