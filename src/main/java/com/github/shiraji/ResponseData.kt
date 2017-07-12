package com.github.shiraji

data class ResponseData(val statusCode: String,
                        val headers: Map<String, String>? = null,
                        val body: String? = null,
                        val exception: Throwable? = null)
