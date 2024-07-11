package com.example.compasstakehome.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.compasstakehome.databinding.RvItemSplitAndCountBinding

class SplitAndCountViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = RvItemSplitAndCountBinding.bind(view)

    fun render(mapString: Pair<String, Int>) {
        binding.characterName.text = mapString.first
        binding.characterNumber.text = mapString.second.toString()
    }

}