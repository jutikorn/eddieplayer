package com.jutikorn.eddieplayer.musiclist.structure.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Song(@SerializedName("albumId") val albumId: Int,
                @SerializedName("id") val id: Int,
                @SerializedName("title") val title: String,
                @SerializedName("url") val url: String,
                @SerializedName("thumbnailUrl") val thumbnailUrl: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(albumId)
        writeInt(id)
        writeString(title)
        writeString(url)
        writeString(thumbnailUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Song> = object : Parcelable.Creator<Song> {
            override fun createFromParcel(source: Parcel): Song = Song(source)
            override fun newArray(size: Int): Array<Song?> = arrayOfNulls(size)
        }
    }
}