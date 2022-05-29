package com.odsstudio.contactsbook.screens

import android.content.Intent
import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.odsstudio.contactsbook.services.Contact
import com.odsstudio.contactsbook.ui.theme.Purple200
import com.odsstudio.contactsbook.view_model.MainViewModel

@Composable
fun MainScreen(contacts: ArrayList<Contact>) {
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        topBar = { TopBar() }
            ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {
                for (contact in contacts) {
                    ContactRow(contact)
                }
            }

    }
}

@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Purple200)) {
        Text(text = "Телефонная книга", fontSize = 25.sp, modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun ContactRow(contact: Contact) {
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Color(0xFF3739E7))
        ) {
        contact.name?.let { Text(text = it, fontSize = 20.sp, modifier = Modifier.padding(3.dp)) }
        contact.phoneNumber?.let { Text(text = it, fontSize = 20.sp) }
    }
}