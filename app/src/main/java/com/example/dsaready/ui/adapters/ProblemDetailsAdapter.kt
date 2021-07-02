package com.example.dsaready.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.databinding.ProblemDetailsItemBinding
import com.example.dsaready.model.TextCodeBlock
import io.github.kbiakov.codeview.CodeView
import io.github.kbiakov.codeview.adapters.Options
import io.github.kbiakov.codeview.highlight.ColorTheme

class ProblemDetailsAdapter(private val problemData:ArrayList<TextCodeBlock>) : RecyclerView.Adapter<ProblemDetailsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ProblemDetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initialize(problemData[position])
    }

    override fun getItemCount(): Int {
        return problemData.size
    }

    class MyViewHolder(itemView: ProblemDetailsItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        var problemHeading: TextView = itemView.textViewHeading
        var problemText: TextView = itemView.textViewTheory
        var problemCode: CodeView = itemView.codeViewTheory


        fun initialize(item: TextCodeBlock) {

            if(item.text.isNotBlank()){
                problemText.text = item.text
            }
            if(item.heading.isNotBlank()){
                problemHeading.text = item.heading
            }
            if(item.code.isNotBlank()){
                problemCode.setOptions(Options.Default.get(problemCode.context).withLanguage("c++").withCode(item.code).withTheme(ColorTheme.DEFAULT))
            }

        }

    }
}