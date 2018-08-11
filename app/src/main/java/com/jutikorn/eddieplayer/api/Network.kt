package com.jutikorn.eddieplayer.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.enqueue(success: (T) -> Unit, failed: (Int?, String?) -> Unit): Call<T> {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>?, t: Throwable?) {
            if (call?.isCanceled == false) {
                failed(null, null)
            }
        }

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if (call?.isCanceled == false) {
                if (response?.isSuccessful == true) {
                    response.body()?.let(success)
                } else {
                    failed.invoke(response?.code(), response?.message())
                }
            }
        }
    })
    return this
}