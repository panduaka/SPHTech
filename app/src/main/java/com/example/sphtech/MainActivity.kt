package com.example.sphtech

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sphtech.net.TestApiResponse
import com.example.sphtech.net.Service
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Service(this@MainActivity).getData(callback = object : Callback<TestApiResponse>{
            override fun onFailure(call: Call<TestApiResponse>, t: Throwable) {
                Log.d("TAG","FAIL")
            }

            override fun onResponse(call: Call<TestApiResponse>, response: retrofit2.Response<TestApiResponse>) {
                Log.d("TAG","SUCCESS")
            }

        })
    }
}
