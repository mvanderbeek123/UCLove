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
        String log=Controler.logged_user;
        profildao.open();
        liste=profildao.selectionnerAleatoire(log);
        profildao.close();
        afficher(liste.get(i));
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
        profildao.open();
        Profil a=profildao.selectionner(login);
        profildao.close();
        name.setText(a.getPrenom()+" "+a.getNom());
        if (a.getCheveux()!=null){
        cheveux.setText(R.string.Cheveux + " : " + a.getCheveux());
        }
        genre.setText(a.getGenre());
        if (a.getLocalisation()!=null){
        localisation.setText(a.getLocalisation());}
        if(a.getYeux()!=null){
        yeux.setText(R.id.yeux + " : "+ a.getYeux());}
        genredao.open();
        ArrayList<Genre> genrelist=genredao.selectionner(login);
        genredao.close();
        if (genrelist.size()==2){
            sexpref.setText(R.string.orientation +": bi");
        }
        else if(genrelist.size()==1)
        {
            sexpref.setText(R.string.orientation + " : " + (genrelist.get(0)).getGenre());
        }
        age.setText(a.getDate_de_naissance().toString());
    }
}
