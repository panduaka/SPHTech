package com.example.sphtech.net

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api/action/datastore_search")
    fun getData(
        @Query("resource_id") resourceId: String,
        @Query("limit") limit: Int
    ): Call<TestApiResponse>
}