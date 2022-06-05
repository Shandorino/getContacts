package com.odsstudio.contactsbook.ui_fragments.notification_fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.databinding.FragmentSecondNotificationBinding


class SecondNotificationFragment : Fragment(R.layout.fragment_second_notification) {

   private val binding: FragmentSecondNotificationBinding by viewBinding()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: SecondNotificationFragmentArgs by navArgs()

        with(binding) {
            resultTextView.text = "Результат равен: ${args.resultData}"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SecondNotificationFragment()
    }
}