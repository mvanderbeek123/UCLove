package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by marie-marie on 28/04/16.
 */
public class ProfilActivity extends Activity {

    EditText nom;
    EditText prenom;
    DatePicker date;
    Spinner sexe;
    Spinner etude;
    EditText ville;
    EditText num;
    Spinner cheveux;
    Spinner yeux;
    Spinner peau;
    Button b;
    ProfilDAO profildao;
    Profil a;
    String nom2;
    String prénom2;
    String genre2;
    String etude2;
    String ville2;
    String num2;
    String cheveux2;
    String yeux2;
    String peau2;
    private int year;
    private int month;
    private int day;
    Date datedenaissance;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        nom= (EditText) findViewById(R.id.button2);
        prenom=(EditText) findViewById(R.id.button3);
        date=(DatePicker) findViewById(R.id.button4);
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        date.init(year, month, day, null);
        sexe=(Spinner) findViewById(R.id.button5);
        etude=(Spinner) findViewById(R.id.button6);
        ville=(EditText) findViewById(R.id.button7);
        num=(EditText) findViewById(R.id.button8);
        cheveux=(Spinner) findViewById(R.id.button10);
        yeux=(Spinner) findViewById(R.id.button9);
        peau=(Spinner) findViewById(R.id.button11);
        b=(Button) findViewById(R.id.valider);
        profildao=new ProfilDAO(this);

        //spinner genre
        List<String> exemple = new ArrayList<String>();
        exemple.add(getString(R.string.masculin));
        exemple.add(getString(R.string.féminin));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexe.setAdapter(adapter);
        //
        //spinner Etude
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
        //
        List<String> listCheveux = new ArrayList<String>();
        listCheveux.add(getString(R.string.noFilters));
        listCheveux.add(getString(R.string.brun));
        listCheveux.add(getString(R.string.blond));
        listCheveux.add(getString(R.string.noir));
        listCheveux.add(getString(R.string.roux));
        listCheveux.add(getString(R.string.gris));
        listCheveux.add(getString(R.string.chauve));
        adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCheveux);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cheveux.setAdapter(adapter3);

        List<String> listYeux = new ArrayList<String>();
        listYeux.add(getString(R.string.noFilters));
        listYeux.add(getString(R.string.brun));
        listYeux.add(getString(R.string.bleu));
        listYeux.add(getString(R.string.vert));
        listYeux.add(getString(R.string.gris));
        adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listYeux);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yeux.setAdapter(adapter4);

        List<String> listPeau = new ArrayList<String>();
        listPeau.add(getString(R.string.noFilters));
        listPeau.add(getString(R.string.noir));
        listPeau.add(getString(R.string.jaune));
        listPeau.add(getString(R.string.blanc));
        listPeau.add(getString(R.string.metisse));
        adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPeau);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        peau.setAdapter(adapter5);
        profildao.open();
        Profil profil=profildao.selectionner(Controler.logged_user);
        profildao.close();
        nom.setText(profil.getNom());
        prenom.setText(profil.getPrenom());
        ville.setText(profil.getLocalisation());
        if (profil.getNumero_de_telephone()!=null)
        {num.setText(profil.getNumero_de_telephone());}
        int spinnerPosition = adapter.getPosition(profil.getGenre());
        sexe.setSelection(spinnerPosition);
        int spinnerPosition2 = adapter2.getPosition(profil.getEtude());
        etude.setSelection(spinnerPosition2);
        if(profil.getCheveux()!=null){
            int spinnerPosition3 = adapter3.getPosition(profil.getCheveux());
            cheveux.setSelection(spinnerPosition3);
        }
        if(profil.getYeux()!=null){
            int spinnerPosition3 = adapter4.getPosition(profil.getYeux());
            yeux.setSelection(spinnerPosition3);
        }
        if(profil.getPeau()!=null){
            int spinnerPosition3 = adapter5.getPosition(profil.getPeau());
            peau.setSelection(spinnerPosition3);
        }
        int day2 =profil.getDate_de_naissance().getDay();
        int month2=profil.getDate_de_naissance().getMonth();
        int year2=profil.getDate_de_naissance().getYear();
        date.init(year2, month2, day2, null);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nom2 = nom.getText().toString();
                prénom2 = prenom.getText().toString();
                ville2 = ville.getText().toString();
                num2 = num.getText().toString();
                genre2 = String.valueOf(sexe.getSelectedItem());
                etude2 = String.valueOf(etude.getSelectedItem());
                cheveux2 = String.valueOf(cheveux.getSelectedItem());
                yeux2 = String.valueOf(yeux.getSelectedItem());
                peau2 = String.valueOf(peau.getSelectedItem());
                datedenaissance = new Date(date.getYear(), date.getMonth(), date.getDayOfMonth());
                a = new Profil(Controler.logged_user, Controler.pw_user, prénom2, nom2, datedenaissance, genre2, etude2, ville2);
                a.setNumero_de_telephone(num2);
                profildao.open();
                profildao.modifier(a);
                profildao.close();
                Toast toast = Toast.makeText(getApplicationContext(), R.string.up, Toast.LENGTH_SHORT);
                toast.show();
                ProfilActivity.this.finish();
            }
        });
    }
}
