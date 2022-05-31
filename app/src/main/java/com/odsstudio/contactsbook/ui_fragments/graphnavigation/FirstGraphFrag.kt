package com.odsstudio.contactsbook.ui_fragments.graphnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.odsstudio.contactsbook.R


class FirstGraphFrag : Fragment() {

    private var navBut: Button? = null

    private val navigatiomClickListener = View.OnClickListener {
        FirstGraphFragDirections.navToSecondFragment("Hello, NavGraphData").apply {
            findNavController().navigate(this)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first_graph, container, false)
        navBut = view.findViewById(R.id.butTo2)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navBut?.setOnClickListener(navigatiomClickListener)
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            FirstGraphFrag()
    }
}