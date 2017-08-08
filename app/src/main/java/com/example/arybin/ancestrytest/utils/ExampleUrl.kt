package com.example.arybin.ancestrytest.utils

import android.content.Context
import com.example.arybin.ancestrytest.R

/**
 * Created on 7/21/17.
 */
internal object ExampleUrl {


  fun getBlackPantherCharacterUrl(context: Context) {
    val url = "https://gateway.marvel.com/v1/public/stories/477?apikey=%s&ts=%s&hash=%s"
  }

  fun getHash(context: Context): String? {
    val publicKey = context.resources.getString(R.string.marvel_public_api_key)
    val privateKey = context.resources.getString(R.string.marvel_private_api_key)
    val ts = System.currentTimeMillis()
    return Md5.hash(ts, privateKey, publicKey)
  }

}
