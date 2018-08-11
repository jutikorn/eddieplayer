package com.jutikorn.eddieplayer.common.extensions

import android.arch.lifecycle.MutableLiveData
import android.databinding.BaseObservable
import android.databinding.Observable

fun <T : BaseObservable> MutableLiveData<T>.setNotifyPropertyChanged() {
    this.value?.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {

        override fun onPropertyChanged(sender: Observable, propertyId: Int) {
            //Trigger LiveData observer on change of any property in object
            this@setNotifyPropertyChanged.value = value

        }
    })
}