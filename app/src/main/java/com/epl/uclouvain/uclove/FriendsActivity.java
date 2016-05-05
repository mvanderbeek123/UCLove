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

    AmisDAO aDAO;
    ArrayList<Amis> ListAmis;
    ArrayList<String> ListLogin;
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

        liste = (ListView) findViewById(R.id.listAmis);ListLogin = new ArrayList<String>();

        aDAO = new AmisDAO(this);
        aDAO.open();
        ListAmis = aDAO.selectionner_listAmis(login_global);
        if(ListAmis == null)
        {
            String texte_2 = res.getString(R.string.noAmis);
            vue.setText(texte_2);
        }
        else
        {
            for (Amis a : ListAmis)
            {
                String log1 = a.getLogin1();
                String log2 = a.getLogin2();
                if(log1 == login_global)
                {
                    ListLogin.add(log2);
                }
                if(log2 == login_global)
                {
                    ListLogin.add(log1);
                }
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.friends, ListLogin);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
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
