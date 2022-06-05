package com.odsstudio.contactsbook.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odsstudio.contactsbook.data.Card
import com.odsstudio.contactsbook.data.Icon
import com.odsstudio.contactsbook.databinding.CardViewHolderBinding
import com.odsstudio.contactsbook.databinding.IconActiveLayoutBinding

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

        holder.onBind(card = item as Card)
    }

    override fun getItemCount(): Int = items.size
}