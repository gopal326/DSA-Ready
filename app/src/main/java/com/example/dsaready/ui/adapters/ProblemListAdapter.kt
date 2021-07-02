package com.example.dsaready.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.dsaready.R
import com.example.dsaready.databinding.ProblemlistItemBinding
import com.example.dsaready.model.Problem
import com.example.dsaready.ui.view.ProblemFragmentDirections
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ProblemListAdapter (private val problemList:ArrayList<Problem>) : RecyclerView.Adapter<ProblemListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = ProblemlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.initialize(problemList[position])

        holder.itemView.setOnClickListener{
            val action  = ProblemFragmentDirections.actionProblemFragmentToProblemDetailsFragment(problemList[position])
            Navigation.findNavController(it).navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return problemList.size
    }

    class MyViewHolder(itemView: ProblemlistItemBinding) : RecyclerView.ViewHolder(itemView.root) {

        var problemTitle: TextView = itemView.problemlistTitle
        var problemDifficulty : Chip = itemView.problemDifficulty
        var problemCompanies : ChipGroup = itemView.chipGroup1


        fun initialize(item: Problem) {

            problemTitle.text=item.problem_title

            if(item.problem_difficulty.isNotBlank()) {
                problemDifficulty.text = item.problem_difficulty
                // setting color for difficulty
                var chipDifficultyColor = when (problemDifficulty.text) {
                    "Easy" -> R.color.Easy
                    "Medium" -> R.color.Medium
                    "Hard" -> R.color.Hard
                    else -> R.color.background
                }
                problemDifficulty.setChipBackgroundColorResource(chipDifficultyColor)
            }

            if(item.problem_companies.isNotBlank()){
                var companies =item.problem_companies
                var companyArray : Array<String> = companies.split(" ").toTypedArray()
                problemCompanies.removeAllViews() // Important

                for(i in companyArray){
                    val chip = Chip(this.problemCompanies.context,null)
                    chip.text=i

                    // setting color for each chip manually since color.parse wasn't working:(
                    var colorTagCompany = when(i){
                        "Apple" -> R.color.Apple
                        "Adobe" -> R.color.Adobe
                        "Amazon" -> R.color.Amazon
                        "Cisco" -> R.color.Cisco
                        "DEShaw" -> R.color.DEShaw
                        "Directi" -> R.color.Directi
                        "Facebook" -> R.color.Facebook
                        "Flipkart" -> R.color.Flipkart
                        "GoldmanSachs" -> R.color.GoldmanSachs
                        "Google" -> R.color.Google
                        "Intuit" -> R.color.Intuit
                        "Linkedin" -> R.color.LinkedIn
                        "Microsoft" -> R.color.Microsoft
                        "MorganStanley" -> R.color.MorganStanley
                        "Oracle" -> R.color.Oracle
                        "Qualcomm" -> R.color.Qualcomm
                        "Samsung" -> R.color.Samsung
                        "Uber" -> R.color.Uber
                        "Walmart" -> R.color.Walmart
                        "Yahoo" -> R.color.Yahoo

                        else -> R.color.background
                    }

                    chip.setChipBackgroundColorResource(colorTagCompany)
                    chip.chipMinHeight=15.0F

                    problemCompanies.chipSpacingVertical=-100
                    problemCompanies.chipSpacingHorizontal=15

                    problemCompanies.addView(chip)
                }
            }

        }

    }
}