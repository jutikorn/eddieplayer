package com.jutikorn.eddieplayer.common.structure

import android.arch.lifecycle.MutableLiveData

interface AppContract {

    interface IViewModel

    interface Repository

    interface UseCase {
        val isLoading: MutableLiveData<Boolean>?
    }

    interface Router

    interface View {
        fun showConnectionProblem(show: Boolean)
        fun showInfoMessage(message: String)
    }
}