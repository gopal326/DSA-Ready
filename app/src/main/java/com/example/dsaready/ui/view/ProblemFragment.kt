package com.example.dsaready.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.databinding.FragmentProblemBinding
import com.example.dsaready.model.Problem
import com.example.dsaready.ui.adapters.ProblemListAdapter


class ProblemFragment : Fragment() {
    lateinit var binding :FragmentProblemBinding
    lateinit var problemRecyclerView: RecyclerView
    lateinit var problemList : ArrayList<Problem>
    private val args by navArgs<ProblemFragmentArgs>()


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = FragmentProblemBinding.inflate(layoutInflater)

        problemRecyclerView = binding.problemList
        problemRecyclerView.layoutManager = LinearLayoutManager(context)
        problemRecyclerView.setHasFixedSize(true)

        problemList= arrayListOf()

        getProblemData()

        return binding.root
    }

    private fun getProblemData(){
        val problemIterator = args.currentTopic.problems
        for(problemValue in problemIterator){
            problemList.add(problemValue)
        }
        problemRecyclerView.adapter= ProblemListAdapter(problemList)
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