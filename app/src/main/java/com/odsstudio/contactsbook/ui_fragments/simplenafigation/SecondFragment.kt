package com.odsstudio.contactsbook.ui_fragments.simplenafigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.odsstudio.contactsbook.R



class SecondFragment(data: String) : Fragment() {

    var myData = data
    var textView: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        textView = view.findViewById(R.id.simpleFragmentData)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        textView?.text = myData
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance(data: String) =
            SecondFragment(data)
    }
}