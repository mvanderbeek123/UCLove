package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by noe on 06/05/16.
 */
public class PropositionsActivity extends Activity {
    MeetDAO mDAO;
    Button yes = null;
    Button no = null;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propositions);

        mDAO = new MeetDAO(this);

        yes = (Button) findViewById(R.id.yesbutton2);
        yes.setOnClickListener(yesListener);
        no = (Button) findViewById(R.id.nobutton2);
        no.setOnClickListener(noListener);

    }

    private View.OnClickListener yesListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mDAO.open();
            mDAO.modif_prop_oui(Controler.meet_user, Controler.logged_user);
            mDAO.close();
            Toast toast = Toast.makeText(getApplicationContext(), R.string.newRdv, Toast.LENGTH_SHORT);
            toast.show();
            PropositionsActivity.this.finish();


        }
    };
    private View.OnClickListener noListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle(R.string.confirmation);
            alertDialogBuilder.setMessage(R.string.refuseProp);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    mDAO.open();
                    mDAO.modif_prop_non(Controler.meet_user, Controler.logged_user);
                    mDAO.close();
                    //On confirme que la prop est confirmée/refusée
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.refuseProp2, Toast.LENGTH_SHORT);
                    toast.show();
                    PropositionsActivity.this.finish();
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
