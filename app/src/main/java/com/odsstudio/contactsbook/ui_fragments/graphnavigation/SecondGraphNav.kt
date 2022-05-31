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


class SecondGraphNav : Fragment() {

    var button: Button? = null
    var textView: TextView? = null

    private val navigationListener = View.OnClickListener {



//        SecondGraphNavDirections.navToFirstFragment().apply {
//            findNavController().navigate(this)
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second_graph_nav, container, false)

        button = view.findViewById(R.id.toFirstButton)
        textView = view.findViewById(R.id.navGraphDataTextView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button?.setOnClickListener(navigationListener)

        val args: SecondGraphNavArgs by navArgs()
        textView?.text = args.navGraphData
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SecondGraphNav()
    }
}