package com.example.lms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lms.databinding.ActivityCourseDetailBinding

class CourseDetailActivity : AppCompatActivity() {
    private var binding : ActivityCourseDetailBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val lessons = listOf(
            Lesson("00 - Trailer", "15:00 min", R.drawable.trailer, false),
            Lesson("01 - Shape", "19:00 min", R.drawable.shape, true),
            Lesson("02 - Coloring", "22:00 min", R.drawable.coloring, true),
            Lesson("03 - Typography", "22:45 min", R.drawable.typography, true),
        )

        val lessonAdapter = LessonListAdapter(lessons)
        binding?.lessonsRecyclerView?.layoutManager = LinearLayoutManager(this@CourseDetailActivity)
        binding?.lessonsRecyclerView?.adapter = lessonAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}