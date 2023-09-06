package com.projemanag.model

import android.os.Parcel
import android.os.Parcelable

// TODO (Step 2: Add a new parameter as document id in which we will store the document id of BOARD.)
// START
data class Board(
    val name: String = "",
    val image: String = "",
    val createdBy: String = "",
    val assignedTo: ArrayList<String> = ArrayList(),
    var documentId: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!,
        source.createStringArrayList()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(image)
        writeString(createdBy)
        writeStringList(assignedTo)
        writeString(documentId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Board> = object : Parcelable.Creator<Board> {
            override fun createFromParcel(source: Parcel): Board = Board(source)
            override fun newArray(size: Int): Array<Board?> = arrayOfNulls(size)
        }
    }
}
// END