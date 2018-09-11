package funnybrain.kaohsiungculturalheritage.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

data class DataItem (
    @SerializedName("Heritage_INDEX")
    @Expose
    val index: String?,

    @SerializedName("Heritage_title")
    @Expose
    val title: String?,

    @SerializedName("Heritage_class")
    @Expose
    val type: String?,

    @SerializedName("Heritage_desc")
    @Expose
    val desc: String?,

    @SerializedName("Heritage_Image")
    @Expose
    val image: List<String> = ArrayList())

