package com.example.arybin.ancestrytest.repositories

/**
 * Created by arybin on 8/7/17.
 */
interface RepositoryCallbacks<in T> {
  fun onLoadFinished(response: T)
  fun onError(t: Throwable)
}