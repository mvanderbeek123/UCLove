package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Steph on 2/05/2016.
 * Sur cette activité, une liste s'affiche si il y a des demandes d'amis, sinon une petite boite
 * de dialogue s'affiche pour lui dire qu'il 'y a pas de nouvelles demandes
 */
public class MyRequests extends Activity {
    AmisDAO aDAO;
    Button profile = null;
    Button yes = null;
    Button no = null;
    Context context=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myrequest);

        aDAO = new AmisDAO(this);

        profile = (Button) findViewById(R.id.viewProfile);
        profile.setOnClickListener(goToProfileListerner);
        yes = (Button) findViewById(R.id.yesbutton);
        yes.setOnClickListener(yesListener);
        no = (Button) findViewById(R.id.nobutton);
        no.setOnClickListener(noListener);
    }

    private View.OnClickListener goToProfileListerner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MyRequests.this, ProfilActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener yesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            aDAO.open();
            aDAO.modif_requete_oui(Controler.requete_user,Controler.logged_user);
            aDAO.close();
            Toast toast=Toast.makeText(getApplicationContext(),R.string.newFriend,Toast.LENGTH_SHORT);
            toast.show();
        }
    };
    private View.OnClickListener noListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle(R.string.confirmation);
            alertDialogBuilder.setMessage(R.string.blockRequestConfirmation);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    aDAO.open();
                    aDAO.modif_requete_non(Controler.requete_user,Controler.logged_user);
                    aDAO.close();
                    //On confirme que la demande est supprimée/bloquée
                    showDialog(1);
                }
            });
            alertDialogBuilder.setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //on retourne simplement en arrière
                    dialog.cancel();
                }
            });
            AlertDialog theAlert = alertDialogBuilder.create();
            theAlert.show();
        }
    };

    @Override
    public Dialog onCreateDialog(int id) {
        Dialog myBox = null;
        switch (id) {
            case 1:
                myBox = new Dialog(this);
                myBox.setTitle(R.string.deleteRequest);
                break;
        }
        return myBox;
    }
}
