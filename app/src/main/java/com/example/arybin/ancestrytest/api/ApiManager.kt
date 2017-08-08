package com.example.arybin.ancestrytest.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by arybin on 8/7/17.
 */
class ApiManager {

  companion object {
    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    private val marvel = retrofit.create(MarvelAPI::class.java)

    fun getMarvelService() : MarvelAPI {
      return marvel
    }
  }
}