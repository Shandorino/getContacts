package com.odsstudio.contactsbook.ui_fragments.contacts_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.adapters.ContactAdapter
import com.odsstudio.contactsbook.contactArraList
import com.odsstudio.contactsbook.data.Contact
import com.odsstudio.contactsbook.databinding.FragmentContactsBinding


class ContactsFragment() : Fragment(R.layout.fragment_contacts) {

    private val binding: FragmentContactsBinding by viewBinding()

    private val contactAdapter: ContactAdapter by lazy { ContactAdapter() }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("itempos", "${contactArraList.toString()} frag")
        with(binding) {
            contactRecycler.adapter = contactAdapter
        }
        contactAdapter.setList(contactArraList)
    }

    companion object {

        @JvmStatic
        fun newInstance() = ContactsFragment()
    }
}