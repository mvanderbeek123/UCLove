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

    TextView nom_view = null;
    TextView genre_view = null;
    TextView age_view = null;
    TextView cheveux_view = null;
    TextView yeux_view = null;
    TextView localisation_view = null;
    TextView sexpref_view = null;

    ImageView photo_profil = null;

    Button supprimer = null;
    Button contact = null;
    CheckBox favori = null;
    Button details = null;
    Button rencontre = null;

    Profil profil = null;

    AmisDAO aDAO = null;

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

        Intent i = getIntent();
        login_ami = i.getStringExtra("com.epl.uclouvain.uclove.amis.LOGIN2");
        login_global = i.getStringExtra("login");

        // Inutile ça non ?
        aDAO = new AmisDAO(this);
        aDAO.open();
        Amis a = aDAO.selectionner_ami(login_global, login_ami);
        aDAO.close();

        ProfilDAO profil_dao = new ProfilDAO(this);
        profil_dao.open();
        profil = profil_dao.selectionner(login_ami);
        profil_dao.close();

        String nom = profil.getNom();
        String genre = profil.getGenre();
        String date_naissance = new SimpleDateFormat("YYYY").format(profil.getDate_de_naissance());
        String date_actuelle = new SimpleDateFormat("YYYY").format(Calendar.getInstance().getTime());
        int age = Integer.parseInt(date_actuelle) - Integer.parseInt(date_naissance);
        String cheveux = profil.getCheveux();
        String yeux = profil.getYeux();
        String localisation = profil.getLocalisation();

        /* PreferenceDAO pref_dao = new PreferenceDAO(this);
        sex =
        */


        nom_view = (TextView)findViewById(R.id.nomAmi);
        nom_view.setText(nom);
        nom_view.setTextColor(0x112233);

        genre_view = (TextView)findViewById(R.id.genre);
        genre_view.setText(genre);

        age_view = (TextView)findViewById(R.id.age);
        age_view.setText(age);

        cheveux_view = (TextView)findViewById(R.id.cheveux);
        cheveux_view.setText(cheveux);

        yeux_view = (TextView)findViewById(R.id.yeux);
        yeux_view.setText(yeux);

        localisation_view = (TextView)findViewById(R.id.localisation);
        localisation_view.setText(localisation);

        /* sexpref_view = (TextView)findViewById(R.id.sexpref);
        sexpref_view.setText(sexpref);

        // image va être du style R.drawable.image
        String image = profil.getImage();
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
        details = (Button)findViewById(R.id.details);
        texte = res.getString(R.string.details);
        details.setText(texte);
        rencontre = (Button)findViewById(R.id.rencontre);
        texte = res.getString(R.string.rencontre);
        rencontre.setText(texte);

        supprimer.setOnClickListener(supprimerListener);
        contact.setOnClickListener(contactListener);
        favori.setOnClickListener(favoriListener);
        details.setOnClickListener(detailsListener);
        rencontre.setOnClickListener(rencontreListener);
    }

    private OnClickListener supprimerListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            aDAO.open();
            aDAO.supprimer(login_global, login_ami);
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
            final String CONTACT = "com.epl.uclouvain.uclove.amis_display.CONTACT";
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
            if(favori.isChecked()) // L'ami est déjà en favori, on veut le retirer.
            {
                aDAO.open();
                aDAO.supprimer_favori(login_global, login_ami);
                aDAO.close();
                favori.setChecked(false);
                texte = res.getString(R.string.favori1);
                favori.setText(texte);
            }
            else // On veut mettre l'ami en favori.
            {
                aDAO.open();
                aDAO.ajouter_favori(login_global, login_ami);
                aDAO.close();
                favori.setChecked(true);
                texte = res.getString(R.string.favori2);
                favori.setText(texte);
            }
        }
    };

    private OnClickListener detailsListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // Copier le layout Profil de Marie.
        }
    };

    private OnClickListener rencontreListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Intent i = new Intent(Friends_display.this, MeetActivity.class);
            final String RENCONTRE = "com.epl.uclouvain.uclove.amis_display.RENCONTRE";
            startActivity(i);
        }
    };
}
