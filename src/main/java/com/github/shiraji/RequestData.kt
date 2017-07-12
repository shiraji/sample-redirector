package com.github.shiraji

import com.google.gson.annotations.SerializedName

data class RequestData(val httpMethod: String,
                       val path: String,
                       val headers: RequestHeaderData,
                       val queryStringParameters: Map<String, String>?)

data class RequestHeaderData(@SerializedName("Host") val domain: String,
                             @SerializedName("User-Agent") val userAgent: String,
                             @SerializedName("CloudFront-Viewer-Country") val countryCode: String)
