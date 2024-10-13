package com.example.lms

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lms.databinding.ItemCourseBinding

class CourseListAdapter(private val courseList: List<Course>) :
    RecyclerView.Adapter<CourseListAdapter.CourseViewHolder>() {

    private val colors = listOf(
        Color.parseColor("#FFB4B4"),
        Color.parseColor("#B4FFE4"),
        Color.parseColor("#1E90FF"),
        Color.parseColor("#FF6348"),
        Color.parseColor("#FFEEB4"),
        Color.parseColor("#CCB4FF"),
    )

    inner class CourseViewHolder(private val itemBinding: ItemCourseBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val cardView: CardView = itemView.findViewById(R.id.courseView)
        fun bindItem(course: Course) {
            itemBinding.courseTitle.text = course.title
            itemBinding.courseSubtitle.text = course.subtitle
            itemBinding.courseImage.setImageResource(course.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            ItemCourseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
        holder.bindItem(course)

        val colorIndex = position % colors.size
        holder.cardView.setCardBackgroundColor(colors[colorIndex])
    }

    override fun getItemCount(): Int {
        return courseList.size
    }
}