package com.odsstudio.contactsbook

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.odsstudio.contactsbook.data.model.Contact
import com.odsstudio.contactsbook.services.MyService
import dagger.hilt.android.AndroidEntryPoint


val BROADCAST_ACTION = "com.odsstudio.broadcastreceve"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Список контаков
        val contactss = mutableStateOf<ArrayList<Contact>>(arrayListOf())


        val permissionGranted = mutableStateOf(false)

        //Получение разрешения
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_CONTACTS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.READ_CONTACTS,
                    android.Manifest.permission.WRITE_CONTACTS
                ),
                1
            )
        } else {

            permissionGranted.value = true

        }
        //Запуск сервиса и получение списка контактов

            val intent = Intent(this, MyService::class.java)

            startService(intent)

//            val br = object : BroadcastReceiver() {
//                 // действия при получении сообщений
//                 override fun onReceive(context: Context?, intent: Intent) {
//                     contactss.value = intent.getParcelableArrayListExtra<Contact>("contacts") as ArrayList<Contact>
//
//                     contactArraList = contactss.value
//
//                    }
//                }

            val intentFilter = IntentFilter(BROADCAST_ACTION)

           //registerReceiver(br, intentFilter)

        setContentView(R.layout.activity_main)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHost.findNavController().setGraph(R.navigation.nav_graph2)

    // Верстка

    }

}




//class MainActivity : ComponentActivity() {
//
//    val vm: MainViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        //Список контаков
//        val contactss = mutableStateOf<ArrayList<Contact>?>(null)
//
//        val permissionGranted = mutableStateOf(false)
//
//        //Получение разрешения
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.READ_CONTACTS
//        ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.WRITE_CONTACTS
//            ) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(android.Manifest.permission.READ_CONTACTS, android.Manifest.permission.WRITE_CONTACTS),
//                1
//            )
//        } else {
//
//            permissionGranted.value = true
//
//        }
//
//        //Запуск сервиса и получение списка контактов
//        if (permissionGranted.value) {
//            val intent = Intent(this, MyService::class.java)
//
//            startService(intent)
//
//            val br = object : BroadcastReceiver() {
//                // действия при получении сообщений
//                override fun onReceive(context: Context?, intent: Intent) {
//                    contactss.value = intent.getParcelableArrayListExtra<Contact>("contacts") as ArrayList<Contact>
//                    Log.d("data111", contactss.toString())
//                }
//            }
//
//            val intentFilter = IntentFilter(BROADCAST_ACTION)
//            registerReceiver(br, intentFilter)
//        }
//
//
//
//        setContent {
//            ContactsBookTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//
//                    if (permissionGranted.value) {
//                        if (contactss.value != null) {
//                            MainScreen(contacts = contactss.value!!)
//                        }
//                    } else {
//                        Dialog(onDismissRequest = { /*TODO*/ }) {
//                            Text("Не было получено разрешение на использование контатов.\nВыдайте разрешение и перезапустите приложение.")
//                        }
//                    }
//                }
//            }
//        }
//
//    }
//}