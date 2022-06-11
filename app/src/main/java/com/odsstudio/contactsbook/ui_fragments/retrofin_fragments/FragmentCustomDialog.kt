package com.odsstudio.contactsbook.ui_fragments.retrofin_fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.databinding.FragmentCustomDialogBinding
import com.odsstudio.contactsbook.view_model.DialogViewModel
import com.odsstudio.contactsbook.workers.LoadWorker
import dagger.hilt.android.AndroidEntryPoint
import java.io.File


@AndroidEntryPoint
class FragmentCustomDialog : DialogFragment(R.layout.fragment_custom_dialog) {

    private val imageUri = MutableLiveData<Uri>()

    private val binding: FragmentCustomDialogBinding by viewBinding()

    private val viewModel: DialogViewModel by viewModels()

    var observer: MyLifecycleObserver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observer = MyLifecycleObserver(requireActivity().activityResultRegistry)
        lifecycle.addObserver(observer!!)
    }

    private fun getImageFormActivity() = View.OnClickListener {
        observer!!.selectImage()
    }

    private fun postButtonListener() = View.OnClickListener {
        with(binding){
//           val user = User(name = , lastName = userLastNameEditText.text.toString(), image = "", id = null)
////            viewModel.postUser(user.toUserApi())
            sendUriToWorker(userNameEditText.text.toString(), userLastNameEditText.text.toString())
        }

    }

    @SuppressLint("RestrictedApi")
    private fun sendUriToWorker(name: String, lastName: String) {

        val workManager by lazy {
            WorkManager.getInstance(requireContext())
        }

        val data = Data.Builder()


        with(data) {
            putString("imageUri", imageUri.value.toString())
            put("userName", name)
            put("userLastName", lastName)
        }


        val request = OneTimeWorkRequest.Builder(LoadWorker::class.java).setInputData(data.build()).build()

        workManager.enqueue(request)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            addImageButton.setOnClickListener(getImageFormActivity())
            imageUri.observe(viewLifecycleOwner) { uri ->
                val asd = File(uri.path).name
                srcImageTextView.text = asd

            }
            postButton.setOnClickListener(postButtonListener())
        }
    }


    inner class MyLifecycleObserver(private val registry : ActivityResultRegistry)
        : DefaultLifecycleObserver {
        lateinit var getContent : ActivityResultLauncher<String>

        override fun onCreate(owner: LifecycleOwner) {
            getContent = registry.register("key", owner, ActivityResultContracts.GetContent()) { uri ->
                imageUri.value = uri
            }
        }

        fun selectImage() {
            getContent.launch("image/*")
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FragmentCustomDialog()
    }
}

