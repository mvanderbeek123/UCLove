package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

/**
 * Created by Steph on 2/05/2016.
 * Dans cette activité, l'utilisateur pourra entrer le pseudonyme d'un utilisateur pour qu'une
 * demande d'amitié lui soit envoyée
 */

//Il reste juste a modifier la base de donnée, mais j'ai besoin de la table client pour faire ca :)
//Si vous voulez tester, mettez 0 ca retourne une boite de dialogue d'erreur
//Pour tout le reste, ca demande une confirmation et puis envoie le formulaire !
public class NewRequest extends Activity {
    private EditText pseudo=null;
    private Button toSend=null;
    private final static String NULL_VALUE="0";
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newrequest);
        pseudo=(EditText) findViewById(R.id.edit_pseudonyme);
        toSend=(Button)findViewById(R.id.send);
        toSend.setOnClickListener(toSendListener);
    }
    private View.OnClickListener toSendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            String text=pseudo.getText().toString();
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            if(text.equals(NULL_VALUE))
            {
                showDialog(0);
            }
            else
            {
                alertDialogBuilder.setTitle("Confirmation");
                alertDialogBuilder.setMessage("Click Yes to confirm");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Rajouter la requete dans la base de donnée
                        NewRequest.this.finish();
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //On retourne juste en arrièr en gardant le texte, car si c'est une long
                        //pseudo, il ne devra pas le retapper.
                        dialog.cancel();
                    }
                });
                AlertDialog theAlert = alertDialogBuilder.create();
                theAlert.show();
            }

        }
    };
    @Override
    public Dialog onCreateDialog (int id) {
        Dialog myBox = null;
        switch (id) {
            case 0:
                myBox = new Dialog(this);
                myBox.setTitle("No match found . Make sure that you haven't a typo");
                break;
        }
        return myBox;
    }
}
