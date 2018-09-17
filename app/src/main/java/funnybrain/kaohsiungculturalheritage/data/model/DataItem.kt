package funnybrain.kaohsiungculturalheritage.data.model;

import android.os.Parcel
import android.os.Parcelable
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
    val image: List<String> = ArrayList()) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createStringArrayList())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(index)
        parcel.writeString(title)
        parcel.writeString(type)
        parcel.writeString(desc)
        parcel.writeStringList(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataItem> {
        override fun createFromParcel(parcel: Parcel): DataItem {
            return DataItem(parcel)
        }

        override fun newArray(size: Int): Array<DataItem?> {
            return arrayOfNulls(size)
        }
    }
}

