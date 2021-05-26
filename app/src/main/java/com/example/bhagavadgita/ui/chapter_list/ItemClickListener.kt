package com.example.bhagavadgita.ui.chapter_list

import com.example.bhagavadgita.domain.Chapter

interface ItemClickListener {

    fun onItemSelected(chapter: Chapter)
}