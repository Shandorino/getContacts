package com.odsstudio.contactsbook

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.core.app.ActivityCompat
import com.odsstudio.contactsbook.screens.MainScreen
import com.odsstudio.contactsbook.services.Contact
import com.odsstudio.contactsbook.services.MyService
import com.odsstudio.contactsbook.ui.theme.ContactsBookTheme
import com.odsstudio.contactsbook.view_model.MainViewModel


    val BROADCAST_ACTION = "com.odsstudio.broadcastreceve"

class MainActivity : ComponentActivity() {

    val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Список контаков
        val contactss = mutableStateOf<ArrayList<Contact>?>(null)

        val permissionGranted = mutableStateOf(false)

        //Получение разрешения
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_CONTACTS, android.Manifest.permission.WRITE_CONTACTS),
                1
            )
        } else {

            permissionGranted.value = true

        }

        //Запуск сервиса и получение списка контактов
        if (permissionGranted.value) {
            val intent = Intent(this, MyService::class.java)

            startService(intent)

            val br = object : BroadcastReceiver() {
                // действия при получении сообщений
                override fun onReceive(context: Context?, intent: Intent) {
                    contactss.value = intent.getParcelableArrayListExtra<Contact>("contacts") as ArrayList<Contact>
                    Log.d("data111", contactss.toString())
                }
            }

            val intentFilter = IntentFilter(BROADCAST_ACTION)
            registerReceiver(br, intentFilter)
        }



        setContent {
            ContactsBookTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    if (permissionGranted.value) {
                        if (contactss.value != null) {
                            MainScreen(contacts = contactss.value!!)
                        }
                    } else {
                        Dialog(onDismissRequest = { /*TODO*/ }) {
                            Text("Не было получено разрешение на использование контатов.\nВыдайте разрешение и перезапустите приложение.")
                        }
                    }
                }
            }
        }

    }
}