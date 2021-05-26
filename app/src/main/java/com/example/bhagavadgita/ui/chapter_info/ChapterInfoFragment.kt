package com.example.bhagavadgita.ui.chapter_info

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.bhagavadgita.R
import com.example.bhagavadgita.databinding.FragmentSecondBinding
import com.example.bhagavadgita.domain.Chapter

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ChapterInfoFragment : Fragment() {

    private var mChapter: Chapter? = null
    private var _binding: FragmentSecondBinding? = null
    private  var mediaPlayer : MediaPlayer?=null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: ChapterInfoFragmentArgs by navArgs()
        mChapter = args.chapter;
        if (mChapter == null) {
            throw NullPointerException("chapter not found")
        }
        (requireActivity() as AppCompatActivity).supportActionBar?.title =mChapter!!.title// "Your Title"


        binding.textview.setText(mChapter!!.title)

        binding.textview.setOnClickListener {
            playAudioFile()
        }
    }

    private fun playAudioFile(){
        if(mediaPlayer!=null && mediaPlayer!!.isPlaying){
            return
        }

        mediaPlayer = MediaPlayer.create(context, R.raw.order_placed)
        mediaPlayer!!.start()
    }


    override fun onResume() {
        super.onResume()
        playAudioFile()
       // Navigation.findNavController(binding.root).currentDestination!!.label=mChapter!!.title
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.stop()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

