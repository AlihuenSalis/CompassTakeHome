package com.example.compasstakehome.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compasstakehome.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.onCreate()

        viewModel.isLoading.observe(this) {
            binding.progressBar.isVisible = it
            binding.rvEvery10thCharacter.isVisible = !it
            binding.rvSplitAndCount.isVisible = !it
            binding.txtTitle.isVisible = !it
            binding.txtTitleSplit.isVisible = !it
            binding.txtTitleCount.isVisible = !it
        }

        viewModel.every10ThCharacter.observe(this) {
            if (it.isNullOrEmpty()) {
                Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show()
            } else {
                binding.rvEvery10thCharacter.layoutManager = LinearLayoutManager(this)
                val adapter = Every10ThCharacterAdapter(it)
                binding.rvEvery10thCharacter.adapter = adapter
            }
        }

        viewModel.splitAndCount.observe(this) {
            if (it.isNullOrEmpty()) {
                Toast.makeText(this, "Data not found", Toast.LENGTH_SHORT).show()
            } else {
                binding.rvSplitAndCount.layoutManager = LinearLayoutManager(this)
                val adapter = SplitAndCountAdapter(it)
                binding.rvSplitAndCount.adapter = adapter
            }
        }
    }
}