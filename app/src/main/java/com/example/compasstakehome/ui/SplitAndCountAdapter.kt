package com.example.compasstakehome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compasstakehome.R

class SplitAndCountAdapter(
    private val splitAndCountList: List<Pair<String, Int>>
): RecyclerView.Adapter<SplitAndCountViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SplitAndCountViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  SplitAndCountViewHolder(
            layoutInflater.inflate(R.layout.rv_item_split_and_count, parent, false)
        )
    }

    override fun getItemCount(): Int = splitAndCountList.size

    override fun onBindViewHolder(holder: SplitAndCountViewHolder, position: Int) {
        val item = splitAndCountList[position]
        holder.render(item)
    }
}