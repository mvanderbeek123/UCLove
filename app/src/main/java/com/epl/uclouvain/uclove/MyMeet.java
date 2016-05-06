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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Steph on 2/05/2016.
 * Sur cette activité, une liste s'affiche si il y a des demandes d'amis, sinon une petite boite
 * de dialogue s'affiche pour lui dire qu'il 'y a pas de nouvelles demandes
 */
public class MyMeet extends Activity {
    MeetDAO mDAO;
    Button profile = null;
    Button yes = null;
    Button no = null;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymeet);

        mDAO = new MeetDAO(this);

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
            Intent intent = new Intent(MyMeet.this, ProfilAffichageActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener yesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mDAO.open();
            mDAO.modif_prop_oui(Controler.requete_user,Controler.logged_user);
            mDAO.close();
            Toast toast=Toast.makeText(getApplicationContext(),R.string.newRDV,Toast.LENGTH_SHORT);
            toast.show();
            MyMeet.this.finish();


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
                    mDAO.open();
                    mDAO.modif_prop_non(Controler.requete_user,Controler.logged_user);
                    mDAO.close();
                    //On confirme que la demande est supprimée/bloquée
                    Toast toast=Toast.makeText(getApplicationContext(),R.string.deleteRDV,Toast.LENGTH_SHORT);
                    toast.show();
                    MyMeet.this.finish();
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
}