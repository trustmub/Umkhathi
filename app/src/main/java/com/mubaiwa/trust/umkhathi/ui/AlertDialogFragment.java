package com.mubaiwa.trust.umkhathi.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.mubaiwa.trust.umkhathi.R;

/**
 * Created by trust on 2016/01/30.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(R.string.error_title)
                .setMessage(R.string.error_message)
                .setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();

        return dialog;
    }
}
