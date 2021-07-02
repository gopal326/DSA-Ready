package com.example.dsaready.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Problem(
        val problem_title : String,
        val problem_difficulty : String,
        val problem_companies : String,
        val problem_body : @RawValue List<TextCodeBlock>
): Parcelable