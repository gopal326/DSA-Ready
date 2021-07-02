package com.example.dsaready.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.databinding.FragmentTheoryBinding
import com.example.dsaready.model.TextCodeBlock
import com.example.dsaready.ui.adapters.TheoryAdapter

class TheoryFragment : Fragment() {
    lateinit var binding:FragmentTheoryBinding
    lateinit var theoryRecyclerView: RecyclerView
    lateinit var theoryTextCodeBlockList : ArrayList<TextCodeBlock>
    private val args by navArgs<TheoryFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding= FragmentTheoryBinding.inflate(layoutInflater)

        theoryRecyclerView = binding.theoryList
        theoryRecyclerView.layoutManager = LinearLayoutManager(context)
        theoryRecyclerView.setHasFixedSize(true)

        theoryTextCodeBlockList= arrayListOf<TextCodeBlock>()

        getTheoryData()

        return binding.root
    }

    private fun getTheoryData(){
        val theoryIterator = args.currentTopic.theory
        for(theoryValue in theoryIterator){
            theoryTextCodeBlockList.add(theoryValue)
        }
        theoryRecyclerView.adapter= TheoryAdapter(theoryTextCodeBlockList)
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }
    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity).supportActionBar!!.show()
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar!!.hide()
    }
}