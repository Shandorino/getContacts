package com.odsstudio.contactsbook.ui_fragments.notification_fragments

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.work.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.odsstudio.contactsbook.R
import com.odsstudio.contactsbook.databinding.FragmentFirstNotificationBinding
import com.odsstudio.contactsbook.view_model.MainViewModel
import com.odsstudio.contactsbook.workers.MyFirstWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit


class FirstNotificationFragment : Fragment(R.layout.fragment_first_notification) {

    private val binding: FragmentFirstNotificationBinding by viewBinding()

    private val viewModel: MainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            firstNumberField.addTextChangedListener(onTextChanged = {
                text, _, _, _ ->
                viewModel.dataChanget(text.toString())
            })

            plusButton.setOnClickListener(plusButtonClickListener)
            minusButton.setOnClickListener(minusButtonClickListener)
            multiplyButton.setOnClickListener(multiplyButtonClickListener)
            divideButton.setOnClickListener(divideButtonClickListener)

            lifecycleScope.launchWhenCreated {
                viewModel.text_.collect {
                    firstNumberTitle.text = it
                }
            }

        }
    }

    private val plusButtonClickListener = View.OnClickListener {
        sendOperantToWorker(
            firstNumber = binding.firstNumberField.text.toString().toInt(),
            secondNumber = binding.secondNumberField.text.toString().toInt(),
            ButtonsType.PLUS
        )
    }
    private val minusButtonClickListener = View.OnClickListener {
        sendOperantToWorker(
            firstNumber = binding.firstNumberField.text.toString().toInt(),
            secondNumber = binding.secondNumberField.text.toString().toInt(),
            ButtonsType.MINUS
        )
    }
    private val multiplyButtonClickListener = View.OnClickListener {
        sendOperantToWorker(
            firstNumber = binding.firstNumberField.text.toString().toInt(),
            secondNumber = binding.secondNumberField.text.toString().toInt(),
            ButtonsType.MULTIPLY
        )
    }
    private val divideButtonClickListener = View.OnClickListener {
        sendOperantToWorker(
            firstNumber = binding.firstNumberField.text.toString().toInt(),
            secondNumber = binding.secondNumberField.text.toString().toInt(),
            ButtonsType.DIVIDE
        )
    }


    private fun sendOperantToWorker(firstNumber: Int, secondNumber: Int, operantType: ButtonsType) {

//        val constraint: Constraints = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.CONNECTED)
//            .build()

//        val request: PeriodicWorkRequest = PeriodicWorkRequestBuilder<MyFirstWorker>(15, TimeUnit.MINUTES)
//            .setConstraints(constraint)
//            .setBackoffCriteria(BackoffPolicy.LINEAR, PeriodicWorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)
//            .build()


        val workManager by lazy {
            WorkManager.getInstance(requireContext())
        }



        val data = Data.Builder()

        with(data) {
            putInt("First number", firstNumber)
            putInt("Second number", secondNumber)
            when(operantType) {
                ButtonsType.PLUS -> putInt("Operant", 0)
                ButtonsType.MINUS -> putInt("Operant", 1)
                ButtonsType.MULTIPLY -> putInt("Operant", 2)
                ButtonsType.DIVIDE -> putInt("Operant", 3)
            }

        }

        val request = OneTimeWorkRequest.Builder(MyFirstWorker::class.java).setInputData(data.build()).build()

//        WorkManager.getInstance(requireContext())
//            .enqueueUniquePeriodicWork("work", ExistingPeriodicWorkPolicy.KEEP, request)

        workManager.enqueue(request)

        workManager.getWorkInfoByIdLiveData(request.id)
            .observe(this) { info ->
                if (info != null && info.state.isFinished) {
                    val result = info.outputData.getInt("Result", 0)

                    Log.d("result", result.toString())

                    toSecondNotificationFragment(result)
                }
            }


    }

    private fun toSecondNotificationFragment(result: Int) {
        FirstNotificationFragmentDirections.toSecondNotificationFragment2(result).apply {
            findNavController().navigate(this)
        }
    }

    enum class ButtonsType{

        PLUS, MINUS, MULTIPLY, DIVIDE

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FirstNotificationFragment()
    }
}

