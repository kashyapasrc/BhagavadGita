package com.example.bhagavadgita.ui.chapter_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bhagavadgita.R
import com.example.bhagavadgita.databinding.FragmentFirstBinding
import com.example.bhagavadgita.domain.Chapter
import com.example.bhagavadgita.ui.chapter_info.ChapterInfoFragment

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ChapterListFragment : Fragment() {

    private lateinit var chapterAdapter: ChapterAdapter
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val arrayList: ArrayList<Chapter> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.chapterList.layoutManager = LinearLayoutManager(context)
        chapterAdapter = ChapterAdapter(arrayList, clickListener)
        binding.chapterList.adapter = chapterAdapter
        binding.chapterList.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        prepareChaptersList()
    }

    val clickListener = object : ItemClickListener {
        override fun onItemSelected(chapter: Chapter) {
            val action=ChapterListFragmentDirections.actionFirstFragmentToSecondFragment(chapter=chapter)
            findNavController().navigate(action)
        }

    }

    fun prepareChaptersList() {
        arrayList.clear()
        for (i in 1..18) {
            arrayList.add(Chapter(1, "Chapter ${i}", ""))
        }

        chapterAdapter.notifyDataSetChanged()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}