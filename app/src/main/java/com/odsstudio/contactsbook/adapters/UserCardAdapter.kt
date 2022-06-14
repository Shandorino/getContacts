package com.odsstudio.contactsbook.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.databinding.UserViewHolderBinding
import com.odsstudio.contactsbook.ui_fragments.retrofin_fragments.FragmentRetrofit

class UserCardAdapter: RecyclerView.Adapter<UserCardAdapter.UserCardViewHolder>() {

    private val items: MutableList<User> = mutableListOf()



    inner class UserCardViewHolder(private val binding: UserViewHolderBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun onBind(user: User) {
            with(binding) {
                firstName.text = user.fullName
                lastName.text = user.email

                Glide.with(binding.root).load("https://top1bot.ru/wsr-food/photos/${user.avatar}").centerCrop().into(mainImage)
            }
        }


    }

    fun setList(list: List<User>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UserViewHolderBinding.inflate(inflater, parent, false)

        return UserCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserCardViewHolder, position: Int) {
        val item = items[position]

        holder.onBind(user = item)
    }

    override fun getItemCount(): Int = items.size


}