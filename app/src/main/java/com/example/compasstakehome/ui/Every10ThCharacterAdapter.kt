package com.example.compasstakehome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.compasstakehome.R

class Every10ThCharacterAdapter (
    private val characterList: List<String>
): RecyclerView.Adapter<Every10ThCharacterViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Every10ThCharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  Every10ThCharacterViewHolder(
            layoutInflater.inflate(R.layout.rv_item_every_10th_character, parent, false)
        )
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: Every10ThCharacterViewHolder, position: Int) {
        val item = characterList[position]
        holder.render(item)
    }
}