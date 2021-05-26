package com.example.bhagavadgita.ui.chapter_list

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bhagavadgita.R
import com.example.bhagavadgita.domain.Chapter

class ChapterViewHolder(itemView: View, val clickListener: ItemClickListener) :
    RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView = itemView.findViewById(R.id.chapter_title_textview)

    init {

    }

    fun onBind(chapter: Chapter) {
        titleTextView.setText(chapter.title)
        titleTextView.isSelected = true
        itemView.setOnClickListener {
            clickListener.onItemSelected(chapter = chapter)
        }
    }
}