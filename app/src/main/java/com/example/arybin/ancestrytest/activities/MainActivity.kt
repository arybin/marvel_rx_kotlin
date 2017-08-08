package com.example.arybin.ancestrytest.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import com.example.arybin.ancestrytest.R
import com.example.arybin.ancestrytest.adapters.CharactersAdapter
import com.example.arybin.ancestrytest.models.MarvelModel
import com.example.arybin.ancestrytest.repositories.CharactersRepository
import com.example.arybin.ancestrytest.repositories.RepositoryCallbacks
import com.example.arybin.ancestrytest.utils.ExampleUrl
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), RepositoryCallbacks<MarvelModel>, SwipeRefreshLayout.OnRefreshListener {
  override fun onRefresh() {
    swipeRefreshLayout.isRefreshing = true
    requestCharactersData()
  }

  private var repository: CharactersRepository? = null
  private var charactersAdapter: CharactersAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    charctersList.apply {
      itemAnimator = DefaultItemAnimator()
      layoutManager = GridLayoutManager(context, SPAN_COUNT)
      adapter = CharactersAdapter()
    }

    repository = CharactersRepository(WeakReference(this))
    swipeRefreshLayout.setOnRefreshListener(this)

  }

  private fun requestCharactersData() {
    repository?.getCharacters(
        this,
        System.currentTimeMillis().toString(),
        ExampleUrl.getHash(this),
        STORY_NUMBER
    )
  }

  override fun onLoadFinished(response: MarvelModel) {
    Timber.d("Characters came back")
    swipeRefreshLayout.isRefreshing = false
    charactersAdapter = charctersList.adapter as? CharactersAdapter
    charactersAdapter?.charachterList = response.data?.results
    charctersList.adapter.notifyDataSetChanged()
  }

  override fun onError(t: Throwable) {
    swipeRefreshLayout.isRefreshing = false
    Timber.wtf(t, "Error when asking for characters list")
  }

  override fun onDestroy() {
    repository?.clearDisposables()
    super.onDestroy()
  }

  companion object {
    private val SPAN_COUNT = 2
    private val STORY_NUMBER = "477"
    private val TAG = MainActivity::class.java.simpleName
  }
}
