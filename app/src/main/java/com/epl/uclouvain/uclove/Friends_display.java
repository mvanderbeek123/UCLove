package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by julien on 1/05/16.
 */
public class Friends_display extends Activity
{
    String login_global;
    String login_ami;

    TextView nom_view;
    TextView genre_view;
    TextView age_view;
    TextView cheveux_view;
    TextView yeux_view;
    TextView localisation_view;
    TextView sexpref_view;

    //ImageView photo_profil;

    Button supprimer;
    Button contact;
    CheckBox favori;
    Button rencontre;

    Profil profil;
    AmisDAO aDAO;
    ProfilDAO profil_dao;

    GenreDAO gDAO;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_affichage);

        Resources res = getResources();
        String texte;
        texte = res.getString(R.string.amis);
        TextView vue = (TextView)findViewById(R.id.titre);
        vue.setText(texte);


        aDAO = new AmisDAO(this);

        profil_dao = new ProfilDAO(this);

        profil_dao.open();
        profil = profil_dao.selectionner(Controler.friend_user);
        profil_dao.close();

        String nom = profil.getPrenom() + " " + profil.getNom();
        nom_view = (TextView)findViewById(R.id.nomAmi);
        nom_view.setText(nom);
        //nom_view.setTextColor(0x112233);

        String genre = profil.getGenre();
        genre_view = (TextView)findViewById(R.id.genre);
        genre_view.setText(genre);


        Date datenaissance = profil.getDate_de_naissance();
        String date = datenaissance.toString();
        age_view = (TextView)findViewById(R.id.age);
        age_view.setText(date);

        String cheveux = profil.getCheveux();
        cheveux_view = (TextView)findViewById(R.id.cheveux);
        cheveux_view.setText(cheveux);

        String yeux = profil.getYeux();
        yeux_view = (TextView)findViewById(R.id.yeux);
        yeux_view.setText(yeux);

        String localisation = profil.getLocalisation();
        localisation_view = (TextView)findViewById(R.id.localisation);
        localisation_view.setText(localisation);

        /*gDAO = new GenreDAO(this);
        gDAO.open();
        ArrayList<Genre> listGenre = gDAO.selectionner(Controler.friend_user);
        gDAO.close();

        if(listGenre.size()>0)
        {
            String sexpref;

            if(listGenre.size() == 2) {sexpref = "Bi";}
            else {sexpref = listGenre.get(0).getGenre();}

            sexpref_view = (TextView)findViewById(R.id.sexpref);
            sexpref_view.setText(sexpref);
        }
        else
        {
            sexpref_view = (TextView)findViewById(R.id.sexpref);
            sexpref_view.setText("");
        }*/




        // image va être du style R.drawable.image
        /* String image = profil.getImage();
        photo_profil.setImageResource(image); */

        supprimer = (Button)findViewById(R.id.supprimer);
        texte = res.getString(R.string.supprimer);
        supprimer.setText(texte);
        contact = (Button)findViewById(R.id.contact);
        texte = res.getString(R.string.contact);
        contact.setText(texte);
        favori = (CheckBox) findViewById(R.id.favori);
        texte = res.getString(R.string.favori1);
        favori.setText(texte);
        rencontre = (Button)findViewById(R.id.rencontre);
        texte = res.getString(R.string.rencontre);
        rencontre.setText(texte);

        supprimer.setOnClickListener(supprimerListener);
        contact.setOnClickListener(contactListener);
        favori.setOnClickListener(favoriListener);
        rencontre.setOnClickListener(rencontreListener);


    }

    private OnClickListener supprimerListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            aDAO.open();
            aDAO.supprimer(Controler.logged_user, Controler.friend_user);
            aDAO.close();
            Intent i = new Intent(Friends_display.this, FriendsActivity.class);
            startActivity(i);
        }
    };

    private OnClickListener contactListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(Friends_display.this, ChatActivity.class);
            startActivity(i);
        }
    };

    private OnClickListener favoriListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {

            Resources res = getResources();
            String texte;
            CheckBox ch = (CheckBox)v;
            if(ch.isChecked()) // L'ami est déjà en favori, on veut le retirer.
            {
                aDAO.open();
                aDAO.ajouter_favori(Controler.logged_user, Controler.friend_user);
                aDAO.close();
                //ch.setChecked(false);
                texte = res.getString(R.string.favori2);
                ch.setText(texte);
            }
            else // On veut mettre l'ami en favori.
            {
                aDAO.open();
                aDAO.supprimer_favori(Controler.logged_user, Controler.friend_user);
                aDAO.close();
                //ch.setChecked(true);
                texte = res.getString(R.string.favori1);
                ch.setText(texte);
            }
        }
    };

    private OnClickListener rencontreListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(Friends_display.this, Meets.class);
            startActivity(i);
        }
    };
}
