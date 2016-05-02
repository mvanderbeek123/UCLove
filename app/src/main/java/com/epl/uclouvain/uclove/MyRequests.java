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

/**
 * Created by Steph on 2/05/2016.
 * Sur cette activité, une liste s'affiche si il y a des demandes d'amis, sinon une petite boite
 * de dialogue s'affiche pour lui dire qu'il 'y a pas de nouvelles demandes
 */
public class MyRequests extends Activity {
    private final static int nberOfRequest = 1;
    Button profile = null;
    Button yes = null;
    Button no = null;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        if (nberOfRequest == 0) {
            setContentView(R.layout.blank);
            alertDialogBuilder.setTitle("Request Message");
            alertDialogBuilder.setMessage("You don't have new request");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //Rajouter la requete dans la base de donnée
                    MyRequests.this.finish();
                }
            });
            AlertDialog theAlert = alertDialogBuilder.create();
            theAlert.show();
        } else {
            setContentView(R.layout.myrequest);
            profile = (Button) findViewById(R.id.viewProfile);
            profile.setOnClickListener(goToProfileListerner);
            yes = (Button) findViewById(R.id.yesbutton);
            yes.setOnClickListener(yesListener);
            no = (Button) findViewById(R.id.nobutton);
            no.setOnClickListener(noListener);
        }


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
            showDialog(0);
        }
    };
    private View.OnClickListener noListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Confirmation");
            alertDialogBuilder.setMessage("Are you sure to block this request");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //On confirme que la demande est supprimée/bloquée
                    showDialog(1);
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
            case 0:
                myBox = new Dialog(this);
                myBox.setTitle("Super, you have a new friend");
                break;
            case 1:
                myBox = new Dialog(this);
                myBox.setTitle("You delete this request");
                break;
        }
        return myBox;
    }
}
