package com.roman_druck.short_book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.roman_druck.short_book.databinding.ActivityDescriptionBinding

class DescriptionActivity : AppCompatActivity() {
   lateinit var binding: ActivityDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}