package com.app.koltinpoc.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.koltinpoc.databinding.AdapterGameItemBinding
import com.app.koltinpoc.databinding.AdapterNewsItemBinding
import com.app.koltinpoc.model.Article
import com.app.koltinpoc.model.GameItem
import com.app.koltinpoc.utils.loadImageFromGlide
import javax.inject.Inject

class GameAdapter @Inject constructor() : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterGameItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffUtil = object : DiffUtil.ItemCallback<GameItem>() {
        override fun areItemsTheSame(oldItem: GameItem, newItem: GameItem): Boolean {

            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: GameItem, newItem: GameItem): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            AdapterGameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = differ.currentList[position]
        holder.binding.apply {
            ivGame.loadImageFromGlide(game.background_image)
            tvName.text = game.name
            tvRelease.text = game.released
            tvRating.text = game.rating.toString()

        }

        holder.itemView.setOnClickListener {
            setArticleClickListener?.let {
                it(game)
            }
        }

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var setArticleClickListener : ((game: GameItem)->Unit)? =null

    fun onArticleClicked(listener:(GameItem)->Unit){
        setArticleClickListener =listener
    }
}