package com.example.dsaready.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.data.Database
import com.example.dsaready.databinding.FragmentHomeBinding
import com.example.dsaready.model.Topic
import com.example.dsaready.ui.adapters.HomeAdapter


class HomeFragment : Fragment() {

    lateinit var topicRecyclerView: RecyclerView
    lateinit var topicArrayList : ArrayList<Topic>
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        topicRecyclerView = binding.homeList
        topicRecyclerView.layoutManager = LinearLayoutManager(context)
        topicRecyclerView.setHasFixedSize(true)

        topicArrayList= arrayListOf()

        getTopicData()

        return binding.root
    }

    private fun getTopicData(){
        val topicIterator = Database.topicList
        for(topic_value in topicIterator){
            topicArrayList.add(topic_value)
        }
        topicRecyclerView.adapter= HomeAdapter(topicArrayList)
    }

}