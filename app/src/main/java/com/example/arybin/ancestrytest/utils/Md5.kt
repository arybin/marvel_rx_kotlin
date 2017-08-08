package com.example.arybin.ancestrytest.utils

import timber.log.Timber
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

/**
 * Created on 7/20/17.
 */

object Md5 {

  fun hash(timestamp: Long, privateKey: String, publicKey: String): String? {
    try {
      val concatResult = timestamp.toString() + privateKey + publicKey
      return md5(concatResult)
    } catch (e: Exception) {
      return null
    }

  }

  private fun md5(s: String): String {
    val MD5 = "MD5"
    try {
      // Create MD5 Hash
      val digest = MessageDigest.getInstance(MD5)
      digest.reset()
      digest.update(s.toByteArray())
      val messageDigest = digest.digest()

      // Create Hex String
      val hexString = StringBuilder()

      for(charByte in messageDigest) {
        var h = Integer.toHexString(0xFF and charByte.toInt())
        while(h.length < 2) {
          h = "0" + h
        }
        hexString.append(h)
      }
      return hexString.toString()

    } catch (e: NoSuchAlgorithmException) {
      Timber.wtf(e, "Error while creating hash")
      e.printStackTrace()
    }

    return ""
  }
}
