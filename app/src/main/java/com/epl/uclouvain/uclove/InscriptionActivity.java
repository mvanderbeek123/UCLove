package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by marie-marie on 2/05/16.
 */
public class InscriptionActivity extends Activity {
    private static int compteur=0;
    private int year;
    private int month;
    private int day;
    private ProfilDAO profildao;
    String inlogin;
    String inmdp;
    String inprénom;
    String innom;
    String inloc;
    String inetude;
    String genre;
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);

        final Spinner liste = (Spinner) findViewById(R.id.spinner);
        List<String> exemple = new ArrayList<String>();
        exemple.add(getString(R.string.masculin));
        exemple.add(getString(R.string.féminin));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        final DatePicker date=(DatePicker) findViewById(R.id.datePicker);
        date.init(year, month, day, null);
        final EditText login=(EditText) findViewById(R.id.login_inscription);
        final EditText mdp=(EditText) findViewById(R.id.motdepasse);
        final EditText prénom=(EditText) findViewById(R.id.prénom);
        final EditText nom=(EditText) findViewById(R.id.nom);
        final EditText loc=(EditText) findViewById(R.id.localisation);
        final Spinner etude=(Spinner) findViewById(R.id.etude);
        final Button valider = (Button) findViewById(R.id.comptecreation);
        List<String> exemple2 = new ArrayList<String>();
        exemple2.add(getString(R.string.droit));
        exemple2.add(getString(R.string.Ingenieur));
        exemple2.add(getString(R.string.Inge));
        exemple2.add(getString(R.string.bioinge));
        exemple2.add(getString(R.string.Architecture));
        exemple2.add(getString(R.string.Histoire));
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etude.setAdapter(adapter2);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (login.getText().toString().equals("") || mdp.getText().toString().equals("") || prénom.getText().toString().equals("")||nom.getText().toString().equals("")||loc.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.vide, Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    inlogin = login.getText().toString();
                    inmdp = mdp.getText().toString();
                    inprénom = prénom.getText().toString();
                    innom = nom.getText().toString();
                    inloc = loc.getText().toString();
                    inetude = String.valueOf(etude.getSelectedItem());
                    genre = String.valueOf(liste.getSelectedItem());
                    Date datedenaissance = new Date(date.getYear(), date.getMonth(), date.getDayOfMonth());
                    profildao = new ProfilDAO(getApplicationContext());
                    profildao.open();
                    if (profildao.existant(inlogin) == false) {
                        Profil profil = new Profil(inlogin, inmdp, inprénom, innom, datedenaissance, genre, inetude, inloc);
                        profildao.ajouter(profil);
                        profildao.close();
                        Intent intent = new Intent(InscriptionActivity.this, Menu.class);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(getApplicationContext(), "ce login est déja utilisé", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
    }});
    }
}