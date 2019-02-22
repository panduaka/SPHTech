package com.example.sphtech.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sphtech.net.Service
import com.example.sphtech.net.TestApiResponse
import retrofit2.Call
import retrofit2.Callback

class MainActivityViewModel : ViewModel() {

    private lateinit var result: MutableLiveData<TestApiResponse>

    fun getData(): MutableLiveData<TestApiResponse> {
        if (!::result.isInitialized) {
            result = MutableLiveData()
            callServerToGetData()
        }
        return result
    }

    private fun callServerToGetData() {
        Service().getData(callback = object : Callback<TestApiResponse> {
            override fun onFailure(call: Call<TestApiResponse>, t: Throwable) {
                Log.d("TAG", "FAIL")
            }

            override fun onResponse(call: Call<TestApiResponse>, response: retrofit2.Response<TestApiResponse>) {
                Log.d("TAG", "SUCCESS")
                result.value = response.body()
            }
        })
    }


}