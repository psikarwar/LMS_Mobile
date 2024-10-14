package com.example.lms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lms.databinding.ItemLessonBinding

class LessonListAdapter(private val lessonList: List<Lesson>) :
    RecyclerView.Adapter<LessonListAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(private val itemBinding: ItemLessonBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindItem(lesson: Lesson) {
            itemBinding.lessonDuration.text = lesson.duration
            itemBinding.lessonTitle.text = lesson.title
            itemBinding.lessonImage.setImageResource(lesson.imageRes)
            itemBinding.lockIcon.visibility = if (lesson.isLocked) View.VISIBLE else View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder(
            ItemLessonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessonList[position]
        holder.bindItem(lesson)
    }

    override fun getItemCount(): Int {
        return lessonList.size
    }
}