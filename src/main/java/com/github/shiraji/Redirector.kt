package com.github.shiraji

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import com.google.gson.GsonBuilder
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter

@Suppress("unused")
class Redirector : RequestStreamHandler {
    private val gson by lazy { GsonBuilder().create() }

    override fun handleRequest(input: InputStream?, output: OutputStream?, context: Context?) {
        val requestData = input?.reader()?.use {
            gson.fromJson(it, RequestData::class.java)
        } ?: throw Exception()

        val response = createResponseData(requestData)

        OutputStreamWriter(output, "UTF-8").use {
            it.write(gson.toJson(response))
        }
    }

    private fun createResponseData(requestData: RequestData): ResponseData {
        // do whatever you want to create response data!
        return ResponseData(statusCode = "301", headers = mapOf("Location" to "http://www.asics.com/jp/ja-jp/"))
    }

}