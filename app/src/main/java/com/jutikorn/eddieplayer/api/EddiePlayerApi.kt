package com.jutikorn.eddieplayer.api

import com.jutikorn.eddieplayer.musiclist.structure.entity.Song
import retrofit2.Call
import retrofit2.http.GET

interface EddiePlayerApi {

    @GET("photos")
    fun getSongs(): Call<List<Song>>
}