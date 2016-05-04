package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by marie-marie on 2/05/16.
 */
public class InscriptionActivity extends Activity {
    private static int compteur=0;
    private int year;
    private int month;
    private int day;
    private ProfilDAO profildao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        DatePicker date=(DatePicker) findViewById(R.id.datePicker);
        date.init(year, month, day, null);
        EditText login=(EditText) findViewById(R.id.login_inscription);
        final EditText mdp=(EditText) findViewById(R.id.motdepasse);
        final EditText prénom=(EditText) findViewById(R.id.prénom);
        EditText nom=(EditText) findViewById(R.id.nom);
        RadioGroup group=(RadioGroup) findViewById(R.id.group);
        EditText loc=(EditText) findViewById(R.id.localisation);
        final EditText etude=(EditText) findViewById(R.id.etude);
        Button valider = (Button) findViewById(R.id.comptecreation);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inlogin = login.getText().toString();
                String inmdp = mdp.getText().toString();
                String inprénom = prénom.getText().toString();
                String innom=nom.getText().toString();
                String inloc=loc.getText().toString();
                String inetude=etude.getText().toString();
                char genre;
                if(group.getCheckedRadioButtonId()==R.id.masculin){
                    genre='M';
                }
                else {
                    genre='F';
                }
                Date datedenaissance=new Date(date.getYear(),date.getMonth(),date.getDayOfMonth());
                Profil profil = new Profil(inlogin,inmdp,inprénom,innom,Date,genre,inetude,inloc);
                profildao=new ProfilDAO(this);
                profildao.ajouter(profil);
                Intent intent = new Intent(this, ProfilActivity.class);
                startActivity(intent);
    }
}
