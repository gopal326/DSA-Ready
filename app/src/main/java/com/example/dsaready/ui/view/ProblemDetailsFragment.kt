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
import com.example.dsaready.databinding.FragmentProblemDetailsBinding
import com.example.dsaready.model.TextCodeBlock
import com.example.dsaready.ui.adapters.ProblemDetailsAdapter


class ProblemDetailsFragment : Fragment() {

    lateinit var binding: FragmentProblemDetailsBinding
    private val args by navArgs<ProblemDetailsFragmentArgs>()
    lateinit var problemDetailsRecyclerView: RecyclerView
    lateinit var problemTextCodeBlockList : ArrayList<TextCodeBlock>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding= FragmentProblemDetailsBinding.inflate(layoutInflater)

        problemDetailsRecyclerView = binding.problemDetails
        problemDetailsRecyclerView.layoutManager = LinearLayoutManager(context)
        problemDetailsRecyclerView.setHasFixedSize(true)

        problemTextCodeBlockList= arrayListOf()

        getProblemDetails()

        return binding.root
    }

    private fun getProblemDetails(){
        val problemDetailsIterator = args.currentProblem.problem_body
        for(problemDetailsValue in problemDetailsIterator){
                problemTextCodeBlockList.add(problemDetailsValue)
        }
        problemDetailsRecyclerView.adapter= ProblemDetailsAdapter(problemTextCodeBlockList)
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