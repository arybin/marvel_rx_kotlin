package com.example.arybin.ancestrytest.repositories

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by arybin on 8/7/17.
 */
abstract class AbstractRepository {
  protected val disposable = CompositeDisposable()

  fun clearDisposables() {
    disposable.clear()
  }
}