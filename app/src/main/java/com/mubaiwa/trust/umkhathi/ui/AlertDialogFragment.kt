package com.mubaiwa.trust.umkhathi.ui

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.Context
import android.os.Bundle
import com.mubaiwa.trust.umkhathi.R

/**
 * Created by trust on 2016/01/30.
 */
class AlertDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        val context: Context = activity
        val builder = AlertDialog.Builder(context)
                .setTitle(R.string.error_title)
                .setMessage(R.string.error_message)
                .setPositiveButton("OK", null)
        return builder.create()
    }
}