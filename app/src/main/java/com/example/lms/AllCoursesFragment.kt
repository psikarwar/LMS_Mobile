package com.example.lms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding = FragmentAllCoursesBinding.inflate(layoutInflater)
        val view = binding?.root

        courseList = listOf(
            Course("Social Media Class", "15 Course", R.drawable.social_media_class),
            Course("3D Illustrations", "10 Course", R.drawable.illustration3d),
            Course("AE Animation", "25 Course", R.drawable.aeanimation),
            Course("AI Design Basic", "35 Course", R.drawable.aidesign),
            Course("Copywriting", "15 Course", R.drawable.copywriting),
            Course("Basic Laravel", "25 Course", R.drawable.basic_laravel),

            // Add more courses
        )

        binding?.recyclerView?.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding?.recyclerView?.adapter = CourseListAdapter(courseList)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
