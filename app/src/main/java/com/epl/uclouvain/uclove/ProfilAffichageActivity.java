package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by marie-marie on 5/05/16.
 */
public class ProfilAffichageActivity extends Activity {
    Button suivant;
    Button precedent;
    TextView name;
    TextView cheveux;
    TextView genre;
    TextView localisation;
    TextView yeux;
    TextView sexpref;
    TextView age;
    ProfilDAO profildao;
    GenreDAO genredao;
    int i=0;
    ArrayList<String> liste;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilaffichage);
        suivant = (Button) findViewById(R.id.suivant);
        precedent = (Button) findViewById(R.id.precedent);
        name=(TextView) findViewById(R.id.nompop);
        cheveux=(TextView) findViewById(R.id.cheveuxpop);
        genre=(TextView) findViewById(R.id.genrepop);
        localisation=(TextView) findViewById(R.id.localisationpop);
        yeux=(TextView) findViewById(R.id.yeuxpop);
        sexpref=(TextView) findViewById(R.id.sexprefpop);
        age=(TextView) findViewById(R.id.agepop);

        Intent intent=getIntent();
        String login=intent.getStringExtra("login");
        profildao=new ProfilDAO(this);
        genredao=new GenreDAO(this);
        profildao.open();
        genredao.open();
        liste=new ArrayList<String>();
        afficher(liste.get(i));
        if(login.compareTo("aleatoire")==0)
        {
            liste=profildao.selectionnerAleatoire();
        }
        else {
            //liste=profildao.
            }
        suivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (i+1<liste.size()){
                i++;
                afficher(liste.get(i));}
                else{
                    Toast t= Toast.makeText(getApplicationContext(), "c'était le dernier profil!", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
        precedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i-1>0){
                    i--;
                    afficher(liste.get(i));}
                else{
                    Toast t= Toast.makeText(getApplicationContext(), "c'était le premier profil!", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }

    public void afficher(String login)
    {
        Profil a=profildao.selectionner(login);
        name.setText(a.getPrenom()+" "+a.getNom());
        cheveux.setText("cheveux de couleur " + a.getCheveux());
        genre.setText(a.getGenre());
        localisation.setText(a.getLocalisation());
        yeux.setText("yeux de couleur " + a.getYeux());
        ArrayList<Genre> genrelist=genredao.selectionner(login);
        if (genrelist.size()==2){
            sexpref.setText("bi");
        }
        else if(genrelist.size()==1)
        {
            sexpref.setText((genrelist.get(0)).getGenre());
        }
        age.setText(a.getDate_de_naissance().toString());
    }
}
