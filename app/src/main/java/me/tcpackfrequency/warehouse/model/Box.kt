package me.tcpackfrequency.warehouse.model

import com.google.gson.annotations.SerializedName

data class Box(@SerializedName("content") val content: String,
               @SerializedName("quantity") val quantity: String,
               @SerializedName("pr") val pr: Boolean,
               @SerializedName("sector") val sector: Int,
               @SerializedName("position") val position: Int)