package com.example.dsaready.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.databinding.TheoryItemBinding
import com.example.dsaready.model.TextCodeBlock
import io.github.kbiakov.codeview.CodeView
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme


class TheoryAdapter(private val theoryList:ArrayList<TextCodeBlock>) : RecyclerView.Adapter<TheoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = TheoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initialize(theoryList[position])
    }

    override fun getItemCount(): Int {
        return theoryList.size
    }

    class MyViewHolder(itemView: TheoryItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        var theoryText: TextView = itemView.textViewTheory
        var theoryHeading: TextView = itemView.textViewHeading
        var theoryCode: CodeView = itemView.codeViewTheory


        fun initialize(item: TextCodeBlock) {

            if(item.text.isNotBlank()){
                theoryText.text = item.text
            }
            if(item.heading.isNotBlank()){
                theoryHeading.text = item.heading
            }

            if(item.code.isNotBlank()){
                theoryCode.setOptions(Options.Default.get(theoryCode.context).withLanguage("c++").withCode(item.code).withTheme(ColorTheme.DEFAULT))
            }

        }

    }
}
