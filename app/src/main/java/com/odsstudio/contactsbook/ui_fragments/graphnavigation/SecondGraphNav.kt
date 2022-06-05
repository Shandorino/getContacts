package com.odsstudio.contactsbook.ui_fragments.graphnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.data.Contact


class SecondGraphNav() : Fragment() {

    var button1: Button? = null
    var button2: Button? = null

    private val navigationToContactsListener = View.OnClickListener {

            SecondGraphNavDirections.navToContactFrag().apply {
                findNavController().navigate(this)
            }

    }

    private val navigationToVerstkaListener = View.OnClickListener {

        SecondGraphNavDirections.navToFirstFragment().apply {
            findNavController().navigate(this)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_graph_nav, container, false)

        button1 = view.findViewById(R.id.toContactsFragment)
        button2 = view.findViewById(R.id.toVerstka)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button1?.setOnClickListener(navigationToContactsListener)
        button2?.setOnClickListener(navigationToVerstkaListener)

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SecondGraphNav()
    }

}