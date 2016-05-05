package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by noe on 02/05/16.
 */
public class RdvActivity extends Activity {

    ListView listView;
    ArrayList<String> dispo;
    //MeetDAO meetDAO;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rdv);

        listView = (ListView) findViewById(R.id.listView2);
        dispo = new ArrayList<String>();

    }
}
