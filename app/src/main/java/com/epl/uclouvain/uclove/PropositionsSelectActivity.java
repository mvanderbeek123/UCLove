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
 * Created by noe on 06/05/16.
 */
public class PropositionsSelectActivity extends Activity {

    ListView listView;
    ArrayAdapter<String> amiAdapteur;
    List<String> logins;
    MeetDAO mdao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propositions);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        listView = (ListView) findViewById(R.id.listprop);
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
                    PropositionsSelectActivity.this.finish();
                }
            });
            AlertDialog theAlert = alertDialogBuilder.create();
            theAlert.show();

        }

        else {
            for (int i = 0; i < mlist.size(); i++) {
                Meet meet = mlist.get(i);
                String log1 = meet.getLogin1();
                Date date = new Date(meet.getDate());
                String dateS = date.toString();
                String lieu = meet.getLieu();
                logins.add(log1 + " souhaiterait vous voir le\n" + dateS + " à " + lieu);
            }

            amiAdapteur = new ArrayAdapter<String>(PropositionsSelectActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, logins);
            listView.setAdapter(amiAdapteur);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Controler.meet_user = logins.get(position);
                    // id n'est pas l'id de l'ami mais celui de la vue, il faut encore le récupérer.
                    Intent i = new Intent(PropositionsSelectActivity.this, MyRequests.class);
                    startActivity(i);
                    PropositionsSelectActivity.this.finish();
                }
            });

        }
    }

}
