package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steph on 2/05/2016.
 * Dans cette activité, l'utilisateur pourra entrer le pseudonyme d'un utilisateur pour qu'une
 * demande d'amitié lui soit envoyée
 */

public class NewRequest extends Activity {
    private EditText pseudo=null;
    private Button toSend=null;
    private final static String NULL_VALUE="0";
    final Context context = this;
    ProfilDAO list;
    AmisDAO adao;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newrequest);
        pseudo=(EditText) findViewById(R.id.edit_pseudonyme);
        toSend=(Button)findViewById(R.id.send);
        toSend.setOnClickListener(toSendListener);
        list=new ProfilDAO(this);
        adao = new AmisDAO(this);
    }
    private View.OnClickListener toSendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            String text=pseudo.getText().toString();
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            list.open();
            Boolean isExist= list.existant(pseudo.getText().toString());
            if(isExist==false)
            {
                showDialog(0);
            }
            else
            {
                alertDialogBuilder.setTitle(R.string.confirmation);
                alertDialogBuilder.setMessage(R.string.clic_to_confirm);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Rajouter la requete dans la base de donnée
                        Amis a= new Amis(Controler.logged_user,pseudo.getText().toString(),0,0);
                        adao.open();
                        adao.ajouter(a);
                        adao.close();
                        Toast toast=Toast.makeText(getApplicationContext(),R.string.envoiNewRequest,Toast.LENGTH_SHORT);
                        toast.show();
                        NewRequest.this.finish();
                        //si la demande existe deja dans un sens ou l'autre + changer message+empecher qqn de s'auto amis

                    }
                });
                alertDialogBuilder.setNegativeButton(R.string.non, new DialogInterface.OnClickListener() {
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
                myBox.setTitle(R.string.error_entree);
                break;
        }
        return myBox;
    }
}
