package com.example.sphtech.net

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TestApiResponse(
    @Json(name = "help") val help: String,
    @Json(name = "success") val success: Boolean,
    @Json(name = "result") val result: Result
)

data class Result(
    @Json(name = "resource_id") val resourceID: String,
    @Json(name = "fields") val fields: List<Field>,
    @Json(name = "records") val records: List<Record>,
    @Json(name = "_links") val links: Links,
    @Json(name = "limit") val limit: Long,
    @Json(name = "total") val total: Long
)

data class Field(
    @Json(name = "type") val type: String,
    @Json(name = "id") val id: String
)

data class Links(
    @Json(name = "start") val start: String,
    @Json(name = "next") val next: String
)

data class Record(
    @Json(name = "volume_of_mobile_data") val volumeOfMobileData: String,
    @Json(name = "quarter") val quarter: String,
    @Json(name = "_id") val id: Long
)