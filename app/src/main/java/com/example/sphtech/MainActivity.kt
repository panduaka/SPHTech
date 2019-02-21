package com.example.sphtech

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sphtech.net.Response
import com.example.sphtech.net.Service
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Service(this@MainActivity).getData(callback = object : Callback<Response>{
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("TAG","FAIL")
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                Log.d("TAG","SUCCESS")
            }

        })
    }
}
