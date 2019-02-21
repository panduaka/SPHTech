package com.example.sphtech.net

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "help") val help: String,
    @Json(name = "success") val success: Boolean,
    @Json(name = "result") val result: Result
)

data class Result(
    @Json(name = "resourceID") val resourceID: String,
    @Json(name = "fields") val fields: List<Field>,
    @Json(name = "records") val records: List<Record>,
    @Json(name = "links") val links: Links,
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
    @Json(name = "volumeOfMobileData") val volumeOfMobileData: String,
    @Json(name = "quarter") val quarter: String,
    @Json(name = "id") val id: Long
)