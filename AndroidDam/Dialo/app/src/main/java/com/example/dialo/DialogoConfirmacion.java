package com.example.dialo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoConfirmacion extends DialogFragment {
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getActivity());

        dialogo.setTitle("");
        dialogo.setMessage("");
        dialogo.setIcon(android.R.drawable.ic_dialog_info);
        dialogo.setTitle("Encuesta covid");
        dialogo.setMessage("¿Te has vacunado?");
        dialogo.setCancelable(false);

        //Aceptar
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Has respondido si", 1).show();;
            }
        });

        //Cancelar
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Has respondido no", 1).show();;
            }
        });

        return dialogo.create();
    }
}
