package com.example.dsaready.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Topic(
        val name : String,
        val no_of_problems : Int,
        val image : Int,
        val introduction : String,
        val theory : @RawValue List<TextCodeBlock>,
        val problems : @RawValue List<Problem>
): Parcelable