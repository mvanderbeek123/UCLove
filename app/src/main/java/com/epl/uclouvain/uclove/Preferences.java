package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marie-marie on 4/05/16.
 */
public class Preferences extends Activity {
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter6;
    ArrayAdapter<String> adapter7;
    ArrayAdapter<String> adapter8;
    ArrayAdapter<String> adapter9;
    ArrayAdapter<String> adapter10;
    Button b;
    GenreDAO genreDAO;
    CheveuxDAO cheveuxDAO;
    YeuxDAO yeuxDAO;
    PeauDAO peauDAO;
    EtudeDAO etudeDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference);
        //spinner genre 1
        genreDAO=new GenreDAO(this);
        yeuxDAO=new YeuxDAO(this);
        cheveuxDAO=new CheveuxDAO(this);
        peauDAO=new PeauDAO(this);
        etudeDAO=new EtudeDAO(this);

        final Spinner liste = (Spinner) findViewById(R.id.spinnergenre1);
        List<String> exemple = new ArrayList<String>();
        exemple.add(getString(R.string.noFilters));
        exemple.add(getString(R.string.masculin));
        exemple.add(getString(R.string.féminin));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);
        //spinner genre 2
        final Spinner liste2 = (Spinner) findViewById(R.id.spinnergenre2);
        List<String> exemple2 = new ArrayList<String>();
        exemple2.add(getString(R.string.noFilters));
        exemple2.add(getString(R.string.masculin));
        exemple2.add(getString(R.string.féminin));
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste2.setAdapter(adapter2);
        //spinner cheveux
        final Spinner liste4 = (Spinner) findViewById(R.id.spinnercheveux);
        List<String> listCheveux = new ArrayList<String>();
        listCheveux.add(getString(R.string.noFilters));
        listCheveux.add(getString(R.string.brun));
        listCheveux.add(getString(R.string.blond));
        listCheveux.add(getString(R.string.noir));
        listCheveux.add(getString(R.string.roux));
        listCheveux.add(getString(R.string.gris));
        listCheveux.add(getString(R.string.chauve));
        adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCheveux);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste4.setAdapter(adapter4);
        //spinner Cheveux 2
        final Spinner liste5 = (Spinner) findViewById(R.id.spinnercheveux2);
        adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listCheveux);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste5.setAdapter(adapter5);
        //spinner cheveux
        final Spinner liste6 = (Spinner) findViewById(R.id.button15);
        List<String> listPeau = new ArrayList<String>();
        listPeau.add(getString(R.string.noFilters));
        listPeau.add(getString(R.string.noir));
        listPeau.add(getString(R.string.jaune));
        listPeau.add(getString(R.string.blanc));
        listPeau.add(getString(R.string.metisse));
        adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPeau);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste6.setAdapter(adapter6);
        //peau 2
        final Spinner liste7 = (Spinner) findViewById(R.id.button17);
        adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPeau);
        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste7.setAdapter(adapter7);
        //Yeux
        final Spinner liste8 = (Spinner) findViewById(R.id.button18);
        List<String> listYeux = new ArrayList<String>();
        listYeux.add(getString(R.string.noFilters));
        listYeux.add(getString(R.string.brun));
        listYeux.add(getString(R.string.bleu));
        listYeux.add(getString(R.string.vert));
        listYeux.add(getString(R.string.gris));
        adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listYeux);
        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste8.setAdapter(adapter8);
        //
        final Spinner liste9 = (Spinner) findViewById(R.id.button16);
        adapter9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listYeux);
        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste9.setAdapter(adapter9);

        final Spinner liste10 = (Spinner) findViewById(R.id.button21);
        List<String> listEtude = new ArrayList<String>();
        listEtude.add(getString(R.string.noFilters));
        listEtude.add(getString(R.string.droit));
        listEtude.add(getString(R.string.Ingenieur));
        listEtude.add(getString(R.string.Inge));
        listEtude.add(getString(R.string.bioinge));
        listEtude.add(getString(R.string.Architecture));
        listEtude.add(getString(R.string.Histoire));
        adapter10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listEtude);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste10.setAdapter(adapter10);
        b=(Button) findViewById(R.id.valider2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genreDAO.open();
                String genre1 = String.valueOf(liste.getSelectedItem());
                if(!genre1.equals(R.string.noFilters)){
                    Genre a=new Genre(Controler.logged_user,genre1);
                    genreDAO.ajouter(a);
                }
                String genre2= String.valueOf(liste2.getSelectedItem());
                if(!genre2.equals(R.string.noFilters)){
                    Genre a=new Genre(Controler.logged_user,genre2);
                    genreDAO.ajouter(a);
                }
                genreDAO.close();
                cheveuxDAO.open();
                String cheveux1=String.valueOf(liste4.getSelectedItem());
                if(!cheveux1.equals(R.string.noFilters)){
                    Cheveux a=new Cheveux(Controler.logged_user,cheveux1);
                    cheveuxDAO.ajouter(a);
                }
                String cheveux2=String.valueOf(liste5.getSelectedItem());
                if(!cheveux2.equals(R.string.noFilters)){
                    Cheveux a=new Cheveux(Controler.logged_user,cheveux2);
                    cheveuxDAO.ajouter(a);
                }
                cheveuxDAO.close();
                peauDAO.open();
                String peau1=String.valueOf(liste6.getSelectedItem());
                if(!peau1.equals(R.string.noFilters)){
                    Peau a=new Peau(Controler.logged_user,peau1);
                    peauDAO.ajouter(a);
                }
                String peau2=String.valueOf(liste7.getSelectedItem());
                if(!peau2.equals(R.string.noFilters)){
                    Peau a=new Peau(Controler.logged_user,peau2);
                    peauDAO.ajouter(a);
                }
                peauDAO.close();
                yeuxDAO.open();
                String yeux1=String.valueOf(liste8.getSelectedItem());
                if(!yeux1.equals(R.string.noFilters)){
                    Yeux a=new Yeux(Controler.logged_user,yeux1);
                    yeuxDAO.ajouter(a);
                }
                String yeux2=String.valueOf(liste9.getSelectedItem());
                if(!yeux2.equals(R.string.noFilters)){
                    Yeux a=new Yeux(Controler.logged_user,yeux2);
                    yeuxDAO.ajouter(a);
                }
                yeuxDAO.close();
                etudeDAO.open();
                String etude=String.valueOf(liste10.getSelectedItem());
                if(!etude.equals(R.string.noFilters)){
                    Etude a=new Etude(Controler.logged_user,etude);
                    etudeDAO.ajouter(a);
                }
                etudeDAO.close();
                Toast toast = Toast.makeText(getApplicationContext(), R.string.up, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
