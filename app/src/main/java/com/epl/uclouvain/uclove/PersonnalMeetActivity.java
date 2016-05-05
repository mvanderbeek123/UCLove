package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by noe on 05/05/16.
 */
public class PersonnalMeetActivity extends Activity {
    ListView listView;
    List<String> meets;
    ArrayAdapter<String> meetsAdapteur;
    MeetDAO  meetdao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personnalmeet);

        listView = (ListView) findViewById(R.id.listView3);
        meets = new ArrayList<String>();

        meetdao = new MeetDAO(this);
        meetdao.open();
        ArrayList<Meet> mlist = meetdao.historique(Controler.logged_user, Controler.meet_user);
        meetdao.close();

        for (int i=0; i<mlist.size(); i++)
        {
            Meet histo = mlist.get(i);
            meets.add(histo.getLogin1() + " propose un rendez-vous le " + new Date(histo.getDate()).toString() + "\n" + "Celui-ci aurait lieu à " + histo.getLieu()) ;
        }

        meetsAdapteur = new ArrayAdapter<String>(PersonnalMeetActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, meets);
        listView.setAdapter(meetsAdapteur);

    }
}
