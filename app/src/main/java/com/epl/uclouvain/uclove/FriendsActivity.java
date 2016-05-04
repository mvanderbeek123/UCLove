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
import android.content.res.Resources;
import java.util.ListIterator;

/**
 * L'activité sur laquelle on arrive en cliquant sur l'onglet "Amis" du menu de départ.
 * */
public class FriendsActivity extends Activity
{
    String login_global;
    ListView liste = null;
    public final static String NOM_INTENT = "com.epl.uclouvain.uclove.amis.LOGIN2";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        Intent i=getIntent();
        login_global = i.getStringExtra("login");

        Resources res = getResources();
        String texte = res.getString(R.string.listeAmis);
        TextView vue = (TextView)findViewById(R.id.textAmis);
        vue.setText(texte);

        liste = (ListView) findViewById(R.id.listAmis);
        ArrayList<String> ListLogin = new ArrayList<String>();

        final AmisDAO aDAO = new AmisDAO(this);
        aDAO.open();
        final ArrayList<Amis> ListAmis = aDAO.selectionner_listAmis(login_global);
        if(ListAmis == null)
        {
            String texte_2 = res.getString(R.string.noAmis);
            vue.setText(texte_2);
        }
        else
        {
            for (Amis a : ListAmis)
            {
                String log = a.getLogin2();
                ListLogin.add(log);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.friends, ListLogin);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                Amis ami = ListAmis.get(position);
                String login_ami = ami.getLogin2();
                Intent i = new Intent(FriendsActivity.this, Friends_display.class);
                i.putExtra(NOM_INTENT, login_ami);
                i.putExtra("login", login_global);
                startActivity(i);
            }
        });
        aDAO.close();
    }
}
