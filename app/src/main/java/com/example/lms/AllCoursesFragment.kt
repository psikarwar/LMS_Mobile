package com.example.lms

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.lms.databinding.FragmentAllCoursesBinding

class AllCoursesFragment : Fragment() {
    private var binding: FragmentAllCoursesBinding? = null
    private lateinit var courseList: List<Course> // This is the list of courses you'll pass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAllCoursesBinding.inflate(inflater, container, false)

        courseList = listOf(
            Course("Social Media Class", "15 Course", R.drawable.social_media_class),
            Course("3D Illustrations", "10 Course", R.drawable.illustration3d),
            Course("AE Animation", "25 Course", R.drawable.aeanimation),
            Course("AI Design Basic", "35 Course", R.drawable.aidesign),
            Course("Copywriting", "15 Course", R.drawable.copywriting),
            Course("Basic Laravel", "25 Course", R.drawable.basic_laravel),
            // Add more courses
        )

        val courseAdapter = CourseListAdapter(courseList)

        binding?.recyclerView?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding?.recyclerView?.adapter = courseAdapter

        courseAdapter.setOnClickListener(object : CourseListAdapter.OnCourseClickListener{
            override fun onCourseClick(position: Int, course: Course) {
                Toast.makeText(activity, "Clicked: ${course.title}", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, CategoryHomeActivity::class.java)
                startActivity(intent)
            }
        })
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
