package com.jutikorn.eddieplayer.api.retrofitadapter

import com.jutikorn.eddieplayer.common.structure.SingleLiveEvent
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

/**
 * A Retrofit adapter that converts the Call into a SingleLiveEvent of ApiResponse.
 * @param <R>
</R> */
class SingleLiveEventCallAdapter<R>(private val responseType: Type) :
    CallAdapter<R, SingleLiveEvent<ApiResponse<R>>> {

    override fun responseType() = responseType

    override fun adapt(call: Call<R>): SingleLiveEvent<ApiResponse<R>> =
            SingleLiveEvent<ApiResponse<R>>().apply {

                call.enqueue(object : Callback<R> {
                    override fun onResponse(call: Call<R>, response: Response<R>) {
                        this@apply.postValue(ApiResponse.create(response))
                    }

                    override fun onFailure(call: Call<R>, throwable: Throwable) {
                        this@apply.postValue(ApiResponse.create(throwable))
                    }
                })
            }
}