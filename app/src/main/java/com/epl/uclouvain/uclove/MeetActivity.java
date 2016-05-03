package com.epl.uclouvain.uclove;

import android.widget.Button;

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
import android.content.res.Resources;

/**
 * L'activité sur laquelle on arrive en cliquant sur l'onglet "Meet" du menu de départ.
 * Created by noe on 02/05/16.
 */
public class MeetActivity extends Activity {
    Button dispo = null;
    Button rdv = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet);

        dispo = (Button) findViewById(R.id.disponibility);
        rdv = (Button) findViewById(R.id.rdv);

        dispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeetActivity.this, Disponibility.class);
                startActivity(intent);
            }
        });
        rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MeetActivity.this, Rdv.class);
                startActivity(intent);
            }
        });
    }
}