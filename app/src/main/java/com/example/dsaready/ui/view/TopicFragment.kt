package com.example.dsaready.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.dsaready.databinding.FragmentTopicBinding


class TopicFragment : Fragment() {
    lateinit var binding:FragmentTopicBinding
    private val args by navArgs<TopicFragmentArgs>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding= FragmentTopicBinding.inflate(layoutInflater)


        binding.textView.setText(args.currentTopic.introduction)
        binding.topicImageView.setImageResource(args.currentTopic.image)

        binding.buttonTheory.setOnClickListener {
            if(args.currentTopic.no_of_problems!=0){
                val action  = TopicFragmentDirections.actionTopicFragmentToTheoryFragment(args.currentTopic, args.position)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                Toast.makeText(this.context, "No Data Filled", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonProblem.setOnClickListener {
            if(args.currentTopic.no_of_problems!=0){
                val action = TopicFragmentDirections.actionTopicFragmentToProblemFragment(args.currentTopic, args.position)
                Navigation.findNavController(it).navigate(action)
            }
            else{
                Toast.makeText(this.context, "No Data Filled", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
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