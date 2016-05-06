package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by noe on 02/05/16.
 */
public class DisponibilityActivity extends Activity {

    CalendarView calendarView;
    TextView dateDisplay;
    EditText log2;
    EditText lieu;
    String date;
    Button confirm;

    AmisDAO adao;
    ArrayList listamis;
    MeetDAO mdao;
    final Context context= this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disponibility);

        confirm = (Button) findViewById(R.id.button);
        log2 = (EditText) findViewById(R.id.editText3);
        lieu = (EditText) findViewById(R.id.editText4);
        confirm.setOnClickListener(confirmListener);
        mdao = new MeetDAO(this);
        adao = new AmisDAO(this);

        listamis = new ArrayList<String>();


        calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setShowWeekNumber(false);
        calendarView.setFirstDayOfWeek(2);
        dateDisplay = (TextView) findViewById(R.id.textView);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                dateDisplay.setText("Date: " + day + " / " + month + " / " + year);
                date="Date: " + day + " / " + month + " / " + year;
            }
        });
    }


    private View.OnClickListener confirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            mdao.open();
            listamis = mdao.selectionner_listProp(Controler.logged_user);
            mdao.close();
            boolean checked = listamis.contains(log2.getText().toString());
            if (checked == false) {
                //si le log entré n'est pas ami
                showDialog(0);
            } else if (log2.getText().toString().equals(Controler.logged_user)) {
                //Si l'utilisateur essaie de s'envoyer un rdv à lui-même
                showDialog(1);
            } else {
                alertDialogBuilder.setTitle(R.string.confirmation);
                alertDialogBuilder.setMessage(R.string.clic_to_confirm);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton(R.string.oui, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Rajouter la requete dans la base de donnée
                        Meet m = new Meet(Controler.logged_user, log2.getText().toString(), date, lieu.getText().toString(), 0);
                        mdao.open();
                        mdao.ajouter(m);
                        mdao.close();
                        Toast toast = Toast.makeText(getApplicationContext(), R.string.envoiNewProp, Toast.LENGTH_SHORT);
                        toast.show();
                        DisponibilityActivity.this.finish();

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

    public Dialog onCreateDialog (int id) {
        Dialog myBox = null;
        switch (id) {
            case 0:
                myBox = new Dialog(this);
                myBox.setTitle(R.string.error_entree);
                break;
            case 1:
                myBox = new Dialog(this);
                myBox.setTitle(R.string.persoRDV);
                break;
        }
        return myBox;
    }

}