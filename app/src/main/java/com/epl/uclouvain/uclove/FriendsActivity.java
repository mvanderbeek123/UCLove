package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.res.Resources;
import java.util.ListIterator;
import android.widget.Spinner;

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
    ArrayAdapter<String> adapter;
    Spinner cheveux;
    Spinner yeux;
    Spinner sexe;

    public final static String NOM_INTENT = "com.epl.uclouvain.uclove.amis.LOGIN2";
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends);

        Intent i=getIntent();
        login_global = i.getStringExtra("login");

        liste = (ListView) findViewById(R.id.listAmis);
        ListLogin = new ArrayList<String>();

        Resources res = getResources();
        String texte = res.getString(R.string.listeAmis);
        TextView vue = (TextView)findViewById(R.id.textAmis);
        vue.setText(texte);


        cheveux = (Spinner) findViewById(R.id.cheveux);
        List<String> listCheveux = new ArrayList<String>();
        String str;
        str = res.getString(R.string.noFilters);
        listCheveux.add(str);
        str = res.getString(R.string.brun);
        listCheveux.add(str);
        str = res.getString(R.string.blond);
        listCheveux.add(str);
        str = res.getString(R.string.noir);
        listCheveux.add(str);
        str = res.getString(R.string.roux);
        listCheveux.add(str);
        str = res.getString(R.string.gris);
        listCheveux.add(str);
        str = res.getString(R.string.chauve);
        listCheveux.add(str);
        ArrayAdapter<String> adapter_cheveux = new ArrayAdapter<String>(FriendsActivity.this, android.R.layout.simple_spinner_item, listCheveux);
        adapter_cheveux.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cheveux.setAdapter(adapter_cheveux);

        yeux = (Spinner) findViewById(R.id.yeux);
        List<String> listYeux = new ArrayList<String>();
        str = res.getString(R.string.noFilters);
        listYeux.add(str);
        str = res.getString(R.string.brun);
        listYeux.add(str);
        str = res.getString(R.string.bleu);
        listYeux.add(str);
        str = res.getString(R.string.vert);
        listYeux.add(str);
        str = res.getString(R.string.gris);
        listYeux.add(str);
        ArrayAdapter<String> adapter_yeux = new ArrayAdapter<String>(FriendsActivity.this, android.R.layout.simple_spinner_item, listYeux);
        adapter_yeux.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yeux.setAdapter(adapter_yeux);


        sexe = (Spinner) findViewById(R.id.sexe);
        List<String> listSexe = new ArrayList<String>();
        str = res.getString(R.string.noFilters);
        listSexe.add(str);
        str = res.getString(R.string.masculin);
        listSexe.add(str);
        str = res.getString(R.string.féminin);
        listSexe.add(str);
        ArrayAdapter<String> adapter_sexe = new ArrayAdapter<String>(FriendsActivity.this, android.R.layout.simple_spinner_item, listSexe);
        adapter_sexe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexe.setAdapter(adapter_sexe);



        aDAO = new AmisDAO(this);
        aDAO.open();
        String selection_cheveux = String.valueOf(cheveux.getSelectedItem());
        if(selection_cheveux.equals("Pas de filtres"))
        {
            selection_cheveux = null ;
        }
        String selection_yeux = String.valueOf(yeux.getSelectedItem());
        if(selection_yeux.equals("Pas de filtres"))
        {
            selection_yeux = null;
        }
        String selection_sexe = String.valueOf(sexe.getSelectedItem());
        if(selection_sexe.equals("Pas de filtres"))
        {
            selection_sexe = null;
        }

        ListAmis = aDAO.selectionner_listAmis(login_global);
        aDAO.close();

        if(ListAmis == null)
        {
            String texte_2 = res.getString(R.string.noAmis);
            vue.setText(texte_2);
        }
        else
        {
            for (int k=0; k<ListAmis.size(); k++)
            {
                Amis a = ListAmis.get(k);
                String log1 = a.getLogin1();
                String log2 = a.getLogin2();
                if(log1.equals(login_global))
                {
                    ListLogin.add(log2);
                }
                else
                {
                    ListLogin.add(log1);
                }
            }
        }

        adapter = new ArrayAdapter<String>(FriendsActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, ListLogin);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Controler.friend_user = ListLogin.get(position);
                // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                Intent i = new Intent(FriendsActivity.this, Friends_display.class);
                startActivity(i);
            }
        });

    }
}
