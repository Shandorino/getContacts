package com.odsstudio.contactsbook.view_model

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore.MediaColumns
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler


//@HiltViewModel
class DialogViewModel : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->

        Log.e("Exception", throwable.toString())

    }

    fun getFilePathFromContentUri(
        selectedVideoUri: Uri,
        contentResolver: ContentResolver
    ): String? {
        val filePath: String
        val filePathColumn = arrayOf(MediaColumns.DATA)
        val cursor: Cursor? =
            contentResolver.query(selectedVideoUri, filePathColumn, null, null, null)
        cursor?.moveToFirst()
        val columnIndex: Int = cursor!!.getColumnIndex(filePathColumn[0])
        filePath = cursor.getString(columnIndex)
        cursor.close()
        return filePath
    }


}