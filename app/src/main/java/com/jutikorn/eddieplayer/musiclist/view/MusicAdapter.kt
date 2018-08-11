package com.jutikorn.eddieplayer.musiclist.view

import com.jutikorn.eddieplayer.R
import com.jutikorn.eddieplayer.common.view.BaseRecyclerViewAdapter
import com.jutikorn.eddieplayer.musiclist.structure.MusicListContract
import com.jutikorn.eddieplayer.musiclist.structure.entity.Song

class MusicAdapter(val interactor: MusicListContract.UseCase) : BaseRecyclerViewAdapter() {

    private var mData: List<Song>? = null

    @Suppress("UNCHECKED_CAST")
    override fun <T> setValues(list: List<T>) {
        mData = list as List<Song>
        notifyDataSetChanged()
    }

    override fun getHandlerForPosition(position: Int): Any? = interactor

    override fun getObjForPosition(position: Int): Any? =
            mData?.getOrNull(position)

    override fun getLayoutIdForPosition(position: Int): Int = R.layout.viewholder_song

    override fun getItemCount(): Int = mData?.size ?: 0
}