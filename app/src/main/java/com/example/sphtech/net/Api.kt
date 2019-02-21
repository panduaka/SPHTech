package com.example.sphtech.net

import retrofit2.http.GET

interface Api {

    @GET
    fun getData()
}