package com.example.dsaready.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.data.Database
import com.example.dsaready.databinding.HomeItemBinding
import com.example.dsaready.model.Topic
import com.example.dsaready.ui.view.HomeFragmentDirections
import java.lang.StringBuilder

class HomeAdapter(private val topicList:ArrayList<Topic>) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=HomeItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initialize(topicList.get(position))

        // setting on click listener
        holder.itemView.setOnClickListener{
            val action  = HomeFragmentDirections.actionHomeFragmentToTopicFragment(Database.topicList[position], position)
            Navigation.findNavController(it).navigate(action)
        }
    }


    class MyViewHolder(itemView: HomeItemBinding): RecyclerView.ViewHolder(itemView.root){

        val topicName : TextView = itemView.homeItemTextview
        var topicString : TextView = itemView.homeItemTextview2
        val topicImage: ImageView =itemView.homeItemImageview



        fun initialize(item: Topic){
            topicName.text=item.name

            var topicStringData= StringBuilder()
            topicStringData.append(" Theory | ")
            topicStringData.append(item.no_of_problems.toString())
            topicStringData.append(" Problems")

            topicString.text=topicStringData


            val address_image = item.image
            topicImage.setImageResource(address_image)
        }

    }
}