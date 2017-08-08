package com.example.arybin.ancestrytest.models

import com.google.gson.annotations.SerializedName

/**
 * Created by arybin on 8/7/17.
 */

data class MarvelModel(
    @SerializedName("data")val data: MarvelData?)

data class MarvelData(
    @SerializedName("count")val count: Int?,
    @SerializedName("results")val results: ArrayList<MarvelCharacter>?
)

data class MarvelCharacter(
    @SerializedName("id") val id:Int?,
    @SerializedName("name") val name:String?,
    @SerializedName("thumbnail") val thumbnail: MarvelThumbnail?
)

data class MarvelThumbnail(
    @SerializedName("path") val path: String?,
    @SerializedName("extension") val extension: String?
)