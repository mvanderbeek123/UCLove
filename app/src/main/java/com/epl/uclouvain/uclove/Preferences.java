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
    ArrayAdapter<String> adapter4;
    ArrayAdapter<String> adapter5;
    ArrayAdapter<String> adapter6;
    ArrayAdapter<String> adapter7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference);
        //spinner genre 1
        final Spinner liste = (Spinner) findViewById(R.id.spinnergenre1);
        List<String> exemple = new ArrayList<String>();
        exemple.add(getString(R.string.masculin));//TODO
        exemple.add(getString(R.string.féminin));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste.setAdapter(adapter);
        //spinner genre 2
        final Spinner liste2 = (Spinner) findViewById(R.id.spinnergenre2);
        List<String> exemple2 = new ArrayList<String>();
        exemple2.add(getString(R.string.masculin));
        exemple2.add(getString(R.string.masculin));
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste2.setAdapter(adapter2);
        //spinner age
        final Spinner liste3 = (Spinner) findViewById(R.id.spinnercheveux);
        List<String> age = new ArrayList<String>();
        age.add("15-30");
        age.add("40-50");
        age.add("50-60");
        age.add("60-70");
        age.add("80-95");
        adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, age);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        liste3.setAdapter(adapter3);
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
    }
}
