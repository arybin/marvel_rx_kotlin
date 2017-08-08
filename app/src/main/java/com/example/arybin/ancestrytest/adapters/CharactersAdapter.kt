package com.example.arybin.ancestrytest.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arybin.ancestrytest.R
import com.example.arybin.ancestrytest.adapters.CharactersAdapter.CharacterViewHolder
import com.example.arybin.ancestrytest.models.MarvelCharacter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_row.view.*

/**
 * Created by arybin on 8/7/17.
 */
class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
  var charachterList: ArrayList<MarvelCharacter>? = null

  override fun onBindViewHolder(holder: CharacterViewHolder?, position: Int) {
    holder?.bind(charachterList?.get(position))
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CharacterViewHolder {
    val view = LayoutInflater.from(parent?.context).inflate(R.layout.character_row, parent,
        false)
    return CharacterViewHolder(view)
  }

  override fun getItemCount(): Int = charachterList?.size ?: 0

  inner class CharacterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(marvelCharacter: MarvelCharacter?) {
      itemView.apply {
        val url = "${marvelCharacter?.thumbnail?.path}.${marvelCharacter?.thumbnail?.extension}"
        Picasso.with(context).load(url).into(characterImage)
        characterName.text = marvelCharacter?.name
      }
    }
  }
}