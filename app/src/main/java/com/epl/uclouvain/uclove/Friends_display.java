package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View.OnClickListener;

/**
 * Created by julien on 1/05/16.
 */
public class Friends_display extends Activity
{
    TextView nom_view = null;
    TextView genre_view = null;
    TextView age_view = null;
    TextView cheveux_view = null;
    TextView yeux_view = null;
    TextView localisation_view = null;
    TextView sexpref_view = null;

    Button supprimer = null;
    Button contact = null;
    CheckBox favori = null;
    Button details = null;
    Button rencontre = null;

    // Profil profil = null;

    AmisDAO aDAO = null;
    long id = 0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_affichage);

        Intent i = getIntent();
        id = i.getLongExtra("com.epl.uclouvain.uclove.amis.ID",0);

        aDAO = new AmisDAO(this);
        aDAO.open();
        Amis a = aDAO.selectionner_parID(id);
        aDAO.close();

        /* profil = on cherche dans la base avec le login qui correspond à l'id.
        String nom = profil.getName();
        char genre = profil.getGenre();
        int age = profil.getAge();
        String cheveux = profil.getCheveux();
        String yeux = profil.getYeux();
        String localisation = profil.getLocalisation();
        // + trouver la préférence je sais pas comment.

        nom_view = (TextView)findViewById(R.id.nomAmi);
        nom_view.setText(nom);
        nom_view.setTextColor(#112233);

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

        sexpref_view = (TextView)findViewById(R.id.sexpref);
        sexpref_view.setText(sexpref);

        // Inclure la photo.
         */
        supprimer = (Button)findViewById(R.id.supprimer);
        contact = (Button)findViewById(R.id.contact);
        favori = (CheckBox) findViewById(R.id.favori);
        details = (Button)findViewById(R.id.details);
        rencontre = (Button)findViewById(R.id.rencontre);

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
            aDAO.supprimer(id);
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
            /* Intent i = new Intent(Friends_display.this, contact.class);
            final String CONTACT = "com.epl.uclouvain.uclove.amis_display.CONTACT";
            i.putExtra(CONTACT, profil);
            startActivity(i); */
        }
    };

    private OnClickListener favoriListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            if(favori.isChecked()) // L'ami est déjà en favori, on veut le retirer.
            {
                aDAO.open();
                aDAO.supprimer_favori(id);
                aDAO.close();
                favori.setChecked(false);
                favori.setText("Marquer comme favori");
            }
            else // On veut mettre l'ami en favori.
            {
                aDAO.open();
                aDAO.ajouter_favori(id);
                aDAO.close();
                favori.setChecked(true);
                favori.setText("Retirer des favoris");
            }
        }
    };

    private OnClickListener detailsListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {

        }
    };

    private OnClickListener rencontreListener = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            /* Intent i = new Intent(Friends_display.this, rencontre.class);
            final String RENCONTRE = "com.epl.uclouvain.uclove.amis_display.RENCONTRE";
            i.putExtra(RENCONTRE, profil);
            startActivity(i); */
        }
    };
}
