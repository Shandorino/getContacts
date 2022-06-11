package com.odsstudio.contactsbook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odsstudio.contactsbook.data.model.Card
import com.odsstudio.contactsbook.databinding.CardViewHolderBinding

class CardAdapter: RecyclerView.Adapter<CardAdapter.CardViewHolder>() {


    var cardclickListener: CardForwardClickListener? = null

    inner class CardViewHolder(private val binding: CardViewHolderBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun onBind(card: Card) {
            with(binding) {
                title.text = card.title
                mainImage.setImageResource(card.picture)
                mainImage.setOnClickListener{
                    cardclickListener?.onClick()
                }
            }

        }
    }

    fun setList(list: List<Card>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    private val items: MutableList<Card>  = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardViewHolderBinding.inflate(inflater, parent, false)

        return CardViewHolder(binding)
    }


    fun interface CardForwardClickListener {
        fun onClick()
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = items[position]

        holder.onBind(card = item)
    }

    override fun getItemCount(): Int = items.size
}