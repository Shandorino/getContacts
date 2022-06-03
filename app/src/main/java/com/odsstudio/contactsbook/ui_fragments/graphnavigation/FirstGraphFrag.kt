package com.odsstudio.contactsbook.ui_fragments.graphnavigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.view.children
import com.odsstudio.contactsbook.data.Icon
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.adapters.CardAdapter
import com.odsstudio.contactsbook.adapters.IconAdapter
import com.odsstudio.contactsbook.data.Card
import com.odsstudio.contactsbook.databinding.FragmentFirstGraphBinding
import com.odsstudio.contactsbook.decorators.IconItemDecorator


class FirstGraphFrag : Fragment(R.layout.fragment_first_graph) {

    private val binding: FragmentFirstGraphBinding by viewBinding()

    private val iconAdapter: IconAdapter by lazy { IconAdapter() }
    private val cardAdapter: CardAdapter by lazy { CardAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            cardRecycler.adapter = cardAdapter
            iconRecycle.adapter = iconAdapter
        }

        iconAdapter.setList(iconList)
        cardAdapter.setList(cardList)
        binding.iconRecycle.addItemDecoration(IconItemDecorator(20,20,16))
    }


    companion object {
        @JvmStatic
        fun newInstance() = FirstGraphFrag()


        private val iconList = listOf<Icon>(
            Icon.Active(id = 0, title = "zero"),
            Icon.Active(id = 1, title = "first"),
            Icon.Disable(id = 2, title = "second"),
            Icon.Active(id = 0, title = "zero"),
            Icon.Active(id = 1, title = "first"),
            Icon.Disable(id = 2, title = "second"),
            Icon.Active(id = 0, title = "zero"),
            Icon.Active(id = 1, title = "first"),
            Icon.Disable(id = 2, title = "second"),
            Icon.Active(id = 0, title = "zero"),
            Icon.Active(id = 1, title = "first"),
            Icon.Disable(id = 2, title = "second"),
        )

        private val cardList = listOf(
            Card(id = 0, title = "first title", picture = R.drawable.microchip),
            Card(id = 0, title = "second title", picture = R.drawable.field),
            Card(id = 0, title = "", picture = R.drawable.audi),
            Card(id = 0, title = "first title", picture = R.drawable.microchip),
            Card(id = 0, title = "second title", picture = R.drawable.field),
            Card(id = 0, title = "", picture = R.drawable.audi),
        )

    }
}