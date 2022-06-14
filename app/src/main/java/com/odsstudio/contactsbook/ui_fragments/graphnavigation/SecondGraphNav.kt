package com.odsstudio.contactsbook.ui_fragments.graphnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.databinding.FragmentSecondGraphNavBinding
import dagger.hilt.android.AndroidEntryPoint


class SecondGraphNav() : Fragment(R.layout.fragment_second_graph_nav) {

    private val binding: FragmentSecondGraphNavBinding by viewBinding()


    private val navigationToContactsListener = View.OnClickListener {

            SecondGraphNavDirections.navToContactFrag().apply {
                findNavController().navigate(this)
            }

    }

    private val navigationToWorkerListener = View.OnClickListener {

        SecondGraphNavDirections.navToWorkerFragment().apply {
            findNavController().navigate(this)
        }

    }

    private val navigationToVerstkaListener = View.OnClickListener {

        SecondGraphNavDirections.navToFirstFragment().apply {
            findNavController().navigate(this)
        }
    }

    private val navigationToRetrofitListener = View.OnClickListener {

        SecondGraphNavDirections.navToFragmentRetrofit().apply {
            findNavController().navigate(this)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            toWorker.setOnClickListener(navigationToWorkerListener)
            toVerstka.setOnClickListener(navigationToVerstkaListener)
            toContactsFragment.setOnClickListener(navigationToContactsListener)
            toRetrofit.setOnClickListener(navigationToRetrofitListener)
        }


        super.onViewCreated(view, savedInstanceState)
    }

    companion object {

        @JvmStatic
        fun newInstance() = SecondGraphNav()
    }

}