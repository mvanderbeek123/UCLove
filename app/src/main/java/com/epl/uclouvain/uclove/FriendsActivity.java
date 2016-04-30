package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        liste = (ListView) findViewById(R.id.listAmis);
        ArrayList<Amis> ListAmis = new ArrayList<Amis>();

        // Ajout des amis en checkant dans la db
        // ListAmis.add("ami1");

        ArrayAdapter<Amis> adapter = new ArrayAdapter<Amis>(this, R.layout.friends, ListAmis);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

            }
        });
    }
}
