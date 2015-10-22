package com.example.erik.modernart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;


public class MoreInfoDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View moreInfoView  = inflater.inflate(R.layout.more_info, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(moreInfoView)
                .setPositiveButton(R.string.visit_moma, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.more_info_link)));
                        startActivity(browserIntent);
                    }
                })
                .setNegativeButton(R.string.cancel_visit_moma, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MoreInfoDialogFragment.this.getDialog().cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
