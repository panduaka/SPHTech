package com.example.sphtech

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sphtech.viewmodels.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var activityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        val data = activityViewModel.getData()
        data.observe(this, Observer {
            val id = it.result.resourceID
            Log.d("TAGGG", id)
        })
    }
}
