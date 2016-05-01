package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
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

/**
 * L'activité sur laquelle on arrive en cliquant sur l'onglet "Amis" du menu de départ.
 * */
public class FriendsActivity extends Activity
{
    ListView liste = null;
    public final static String NOM_INTENT = "com.epl.uclouvain.uclove.amis.ID";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        liste = (ListView) findViewById(R.id.listAmis);
        ArrayList<Amis> ListAmis = new ArrayList<Amis>();
        ArrayList<String> ListLogin = new ArrayList<String>();

        final AmisDAO aDAO = new AmisDAO(this);
        aDAO.open();
        ListAmis = aDAO.selectionner_siAmi(1);
        if(ListAmis == null)
        {
            ListLogin.add("Vous n'avez pas encore d'amis.");
        }
        else
        {
            for (Amis a : ListAmis) {
                String log = a.getLogin();
                ListLogin.add(log);
            }
        }
        aDAO.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.friends, ListLogin);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                Intent i = new Intent(FriendsActivity.this, Friends_display.class);
                i.putExtra(NOM_INTENT, id);
                startActivity(i);
            }
        });
    }
}

/*
liste = (ListView) findViewById(R.id.listAmis);
        ArrayList<Amis> ListAmis = new ArrayList<Amis>();

        // Ajout des amis en checkant dans la db
        // ListAmis.add("ami1");

        ArrayAdapter<Amis> adapter = new ArrayAdapter<Amis>(this, R.layout.friends, ListAmis);
        liste.setAdapter(adapter);
 */
