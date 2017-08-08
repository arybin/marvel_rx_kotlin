package com.example.arybin.ancestrytest.api

import com.example.arybin.ancestrytest.models.MarvelModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by arybin on 8/7/17.
 */
interface MarvelAPI {

  @GET("stories/{story}/characters")
  fun getCharacters(
      @Path("story") story:String,
      @Query("apikey") apikey:String,
      @Query("ts")   ts:String,
      @Query("hash") hash:String?
  ): Observable<MarvelModel?>
}