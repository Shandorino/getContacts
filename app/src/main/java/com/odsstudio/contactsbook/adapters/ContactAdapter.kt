package com.odsstudio.contactsbook.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.data.Contact
import com.odsstudio.contactsbook.databinding.ContactsLayoutBinding
import com.odsstudio.contactsbook.databinding.FragmentContactsBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {




    inner class ContactViewHolder(private val binding: ContactsLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun onBind(contact: Contact) {
                with(binding) {
                    contactName.text = contact.name
                    dropdownButton.setOnClickListener {
                        if (contact.childVisibility) {
                            contactNumber.isVisible = false
                            contact.childVisibility = false
                        }
                        else {
                            contactNumber.isVisible = true
                            contact.childVisibility = true
                        }
                    }
                    contactNumber.text = contact.phoneNumber
                }
            }
        }

    fun setList(list: ArrayList<Contact>?) {
        items.clear()
        if (list != null)
            items.addAll(list)
        notifyDataSetChanged()
    }
    private val items: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactsLayoutBinding.inflate(inflater, parent, false)

        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = items[position]

        holder.onBind(contact = item as Contact)


    }

    override fun getItemCount(): Int = items.size
}