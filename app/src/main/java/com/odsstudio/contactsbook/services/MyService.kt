package com.odsstudio.contactsbook.services

import android.annotation.SuppressLint
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract
import android.text.TextUtils
import android.util.Log
import com.odsstudio.contactsbook.BROADCAST_ACTION
import com.odsstudio.contactsbook.data.Contact

class MyService : Service() {

    private val CONTACT_ID = ContactsContract.Contacts._ID
    private val DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME
    private val HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER
    private val PHONE_NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER
    private val PHONE_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        val contacts: ArrayList<Contact>? = getAllContacts(this)

        Log.d("data111", contacts.toString())

        val intent111 = Intent(BROADCAST_ACTION).apply {
            if (contacts != null) {
                putExtra("contacts", contacts)
            }
        }

        sendBroadcast(intent111)
        stopService(Intent(this, MyService::class.java))
    }

    //Получение контактов
    @SuppressLint("Range", "Recycle")
    fun getAllContacts(context: Context): ArrayList<Contact>? {
        val cr = context.contentResolver

        val pCur = cr.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            arrayOf(PHONE_NUMBER, PHONE_CONTACT_ID),
            null,
            null,
            null
        )

        if (pCur != null) {
            if (pCur.count > 0) {
                val phones = HashMap<Int, ArrayList<String>>()
                while (pCur.moveToNext()) {

                    val contactId: Int = pCur.getInt(pCur.getColumnIndex(PHONE_CONTACT_ID))

                    var curPhones = arrayListOf<String>()

                    if (phones.containsKey(contactId)) {
                        curPhones = phones.get(contactId)!!
                    }

                    curPhones.add(pCur.getString(pCur.getColumnIndex(PHONE_NUMBER)))
                    phones.put(contactId, curPhones)
                }

                val cur = cr.query(
                    ContactsContract.Contacts.CONTENT_URI,
                    arrayOf(CONTACT_ID, DISPLAY_NAME, HAS_PHONE_NUMBER),
                    "$HAS_PHONE_NUMBER > 0",
                    null,
                    "$DISPLAY_NAME ASC"
                )
                if (cur != null) {
                    if (cur.count > 0) {
                        val contacts = arrayListOf<Contact>()

                        while (cur.moveToNext()) {
                            val id = cur.getInt(cur.getColumnIndex(CONTACT_ID))

                            if (phones.containsKey(id)) {
                                val con = Contact(cur.getString(cur.getColumnIndex(DISPLAY_NAME)), TextUtils.join(",",
                                    phones[id]!!.toArray()
                                ))
                                contacts.add(con)
                            }
                        }
                        return contacts
                    }
                    cur.close()
                }
            }
            pCur.close()
        }
        return null
    }

}


