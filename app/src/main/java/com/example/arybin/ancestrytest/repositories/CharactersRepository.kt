package com.example.arybin.ancestrytest.repositories

import android.content.Context
import com.example.arybin.ancestrytest.R
import com.example.arybin.ancestrytest.api.ApiManager
import com.example.arybin.ancestrytest.models.MarvelModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.ref.WeakReference

/**
 * Created by arybin on 8/7/17.
 */
class CharactersRepository(val reference: WeakReference<RepositoryCallbacks<MarvelModel>>) : AbstractRepository() {

  fun getCharacters(context: Context, ts: String, hash:String?, story:String) {
    disposable.add(ApiManager
        .getMarvelService()
        .getCharacters(story, context.getString(R.string.marvel_public_api_key), ts, hash)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ data ->
          Timber.e("reponse is here ${data.data?.results?.size}")
          reference.get()?.onLoadFinished(data)
        }, { error ->
          Timber.wtf("Something bad happened")
          reference.get()?.onError(error)
        })
    )
  }
}