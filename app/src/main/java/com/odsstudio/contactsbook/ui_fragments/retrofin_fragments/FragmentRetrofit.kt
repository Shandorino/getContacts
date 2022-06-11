package com.odsstudio.contactsbook.ui_fragments.retrofin_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.adapters.UserCardAdapter
import com.odsstudio.contactsbook.data.model.User
import com.odsstudio.contactsbook.databinding.FragmentRetrofitBinding
import com.odsstudio.contactsbook.view_model.RetrofitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentRetrofit : Fragment(R.layout.fragment_retrofit) {


    private val binding: FragmentRetrofitBinding by viewBinding()

    private val viewModel: RetrofitViewModel by viewModels()

    private val userCardAdapter: UserCardAdapter by lazy { UserCardAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getUser()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        lifecycleScope.launchWhenCreated {
            with(viewModel) {
                user.collect {
                    userCardAdapter.setList(it)
                }
            }
        }

        with(binding) {
            addUserTextView.setOnClickListener(navToCustomDialog())
            usersRecycler.adapter = userCardAdapter
        }
    }


    private fun navToCustomDialog() = View.OnClickListener {

        FragmentRetrofitDirections.navToFragmentCustomDialog().apply {
            findNavController().navigate(this)
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentRetrofit()

       // val user = listOf<User>(User(1, "андрей", "Васильев"))

    }
}