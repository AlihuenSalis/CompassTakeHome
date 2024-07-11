package com.example.compasstakehome.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.compasstakehome.databinding.RvItemEvery10thCharacterBinding

class Every10ThCharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = RvItemEvery10thCharacterBinding.bind(view)

    fun render(string: String) {
        binding.tvName.text = string
    }
}