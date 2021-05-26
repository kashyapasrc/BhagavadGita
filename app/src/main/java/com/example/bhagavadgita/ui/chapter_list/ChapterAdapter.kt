package com.example.bhagavadgita.ui.chapter_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bhagavadgita.R
import com.example.bhagavadgita.domain.Chapter

class ChapterAdapter(var arrayList: ArrayList<Chapter>,val clickListener: ItemClickListener) :

    RecyclerView.Adapter<ChapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder =
        ChapterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chapter_view, parent, false),clickListener
        )


    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.onBind(arrayList.get(position))
    }

    override fun getItemCount(): Int = arrayList.size

}