package com.odsstudio.contactsbook.ui_fragments.simplenafigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.odsstudio.contactsbook.R

class FirstFragment: Fragment() {

    private var navBut: Button? = null

    private val navigatiomClickListener = View.OnClickListener {
        navigateToSecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_layout, container, false)
        navBut = view.findViewById(R.id.navToSec)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navBut?.setOnClickListener(navigatiomClickListener)
        super.onViewCreated(view, savedInstanceState)
    }

    private fun navigateToSecondFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container, SecondFragment.newInstance("simple fragment data"))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FirstFragment()
    }

}