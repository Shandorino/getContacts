package com.odsstudio.contactsbook.ui_fragments.room_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.adapters.NoteAdapter
import com.odsstudio.contactsbook.databinding.FragmentRoomBinding
import com.odsstudio.contactsbook.view_model.RoomViewModel


class FragmentRoom : Fragment(R.layout.fragment_room) {

    val binding: FragmentRoomBinding by viewBinding()

    val viewModel: RoomViewModel by viewModels()

    val noteCardAdapter: NoteAdapter by lazy { NoteAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    companion object {
        @JvmStatic
        fun newInstance() = FragmentRoom()
    }
}