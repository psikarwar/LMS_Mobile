package com.example.lms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lms.databinding.ActivityCategoryHomeBinding

class CategoryHomeActivity : AppCompatActivity() {
    private var binding : ActivityCategoryHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}