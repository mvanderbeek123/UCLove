package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marie-marie on 4/05/16.
 */
public class Preferences extends Activity {
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference);
        //spinner genre 1
        final Spinner liste = (Spinner) findViewById(R.id.spinnergenre1);
        List<String> exemple = new ArrayList<String>();
        exemple.add("Masculin");//TODO
        exemple.add("féminin");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);
        //spinner genre 2
        final Spinner liste2 = (Spinner) findViewById(R.id.spinnergenre2);
        List<String> exemple2 = new ArrayList<String>();
        exemple2.add("masculin");
        exemple2.add("féminin");
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste2.setAdapter(adapter2);
        //spinner age
        final Spinner liste3 = (Spinner) findViewById(R.id.spinnercheveux);
        List<String> exemple3 = new ArrayList<String>();
        exemple3.add("brun");
        exemple3.add("blond");
        adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste2.setAdapter(adapter3);

    }
}
