package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delphine on 03/05/16.
 */
public class ChatSelectActivity extends Activity
{
    ListView listView;
    ArrayAdapter<String> amiAdapteur;
    List<String> logins;
    AmisDAO  adao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_select);
        listView = (ListView) findViewById(R.id.listAmis);
        logins = new ArrayList<String>();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        adao = new AmisDAO(this);
        adao.open();
        ArrayList<Amis> alist = adao.selectionner_listAmis(Controler.logged_user);
        adao.close();

        if (alist.size() == 0) {
            setContentView(R.layout.blank);
            alertDialogBuilder.setTitle(R.string.chatMessage);
            alertDialogBuilder.setMessage(R.string.noAmis);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton(R.string.ok_text, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    ChatSelectActivity.this.finish();
                }
            });
            AlertDialog theAlert = alertDialogBuilder.create();
            theAlert.show();

        }

        else {

            for (int i = 0; i < alist.size(); i++) {
                Amis amis = alist.get(i);
                String log1 = amis.getLogin1();
                String log2 = amis.getLogin2();
                if (log1.equals(Controler.logged_user))
                    logins.add(log2);
                else
                    logins.add(log1);
            }

            amiAdapteur = new ArrayAdapter<String>(ChatSelectActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, logins);
            listView.setAdapter(amiAdapteur);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Controler.chat_user = logins.get(position);
                    // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                    Intent i = new Intent(ChatSelectActivity.this, ChatActivity.class);
                    startActivity(i);
                }
            });
        }
    }
}