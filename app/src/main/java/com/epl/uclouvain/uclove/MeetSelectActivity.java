package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by delph on 05/05/16.
 */
public class MeetSelectActivity extends Activity {

    ListView listView;
    ArrayAdapter<String> amiAdapteur;
    List<String> logins;
    MeetDAO mdao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet_select);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        listView = (ListView) findViewById(R.id.listAmis);
        logins = new ArrayList<String>();

        mdao = new MeetDAO(this);
        mdao.open();
        ArrayList<Meet> mlist = mdao.selectionner_listProp(Controler.logged_user);
        mdao.close();

        if (mlist.size() == 0) {
            setContentView(R.layout.blank);
            alertDialogBuilder.setTitle(R.string.requestMessage);
            alertDialogBuilder.setMessage(R.string.noNewProp);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton(R.string.ok_text, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //Rajouter la requete dans la base de donnée
                    MeetSelectActivity.this.finish();
                }
            });
            AlertDialog theAlert = alertDialogBuilder.create();
            theAlert.show();

        } else {
            for (int i = 0; i < mlist.size(); i++) {
                Meet meet = mlist.get(i);
                String log1 = meet.getLogin1();
                String date = meet.getDate();
                String lieu = meet.getLieu();
                logins.add(log1 + " souhaiterait vous voir le\n" + date + " à " + lieu);
            }

            amiAdapteur = new ArrayAdapter<String>(MeetSelectActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, logins);
            listView.setAdapter(amiAdapteur);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Controler.meet_user = logins.get(position);
                    // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                    Intent i = new Intent(MeetSelectActivity.this, MyRequests.class);
                    startActivity(i);
                    MeetSelectActivity.this.finish();
                }
            });

        }
    }

}
    /*ListView listView;
    ArrayAdapter<String> amiAdapteur;
    List<String> logins;
    AmisDAO adao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet_select);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        listView = (ListView) findViewById(R.id.listAmis);
        logins = new ArrayList<String>();

        adao = new AmisDAO(this);
        adao.open();
        ArrayList<Amis> alist = adao.selectionner_listRDV(Controler.logged_user);
        adao.close();

        if (alist.size() == 0) {
            setContentView(R.layout.blank);
            alertDialogBuilder.setTitle(R.string.RDVMessage);
            alertDialogBuilder.setMessage(R.string.noNewRDV);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton(R.string.ok_text, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    MeetSelectActivity.this.finish();
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
                logins.add(log1);
            }

            amiAdapteur = new ArrayAdapter<String>(MeetSelectActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, logins);
            listView.setAdapter(amiAdapteur);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Controler.rdv_user = logins.get(position);
                    // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                    Intent i = new Intent(MeetSelectActivity.this, MyMeet.class);
                    startActivity(i);
                    MeetSelectActivity.this.finish();
                }
            });

        }
    }
}*/