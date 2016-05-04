package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by delphine on 02/05/16.
 */
public class ChatActivity extends Activity
{
    ListView listView;
    List<String> messages;
    ArrayAdapter<String> messageAdapteur;
    ChatDAO  chatdao;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        listView = (ListView) findViewById(R.id.listView);
        messages = new ArrayList<String>();

        chatdao = new ChatDAO(this);
        chatdao.open();
        ArrayList<ChatMessage> cmlist = chatdao.historique(Controler.logged_user, Controler.chat_user);
        chatdao.close();

        for (int i=0; i<cmlist.size(); i++)
        {
            ChatMessage histo = cmlist.get(i);
            messages.add(histo.getLogin1() + "                  " + histo.getMsg_date()) ;

            messages.add(histo.getMsg());
            messages.add("");
        }

        messageAdapteur = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, messages);
        listView.setAdapter(messageAdapteur);

        final EditText editMessage = (EditText) findViewById(R.id.message);

        Button btnEnvoie = (Button) findViewById(R.id.envoyer);
        btnEnvoie.setOnClickListener(new OnClickListener() {

            @SuppressWarnings("deprecation")
            public void onClick(View v) {
                String msg = editMessage.getText().toString();
                String msgdate = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
                if (msg.length() > 0) {

                    //SmsManager.getDefault().sendTextMessage(num, null, msg, null, null);
                    // texte devrait etre ajouter dans la base de donnee

                    editMessage.setText("");
                    messages.add(Controler.logged_user + "                  " + msgdate);
                    messages.add(msg);
                    messages.add("");

                    ChatMessage cm = new ChatMessage();
                    cm.setMsg(msg);
                    cm.setLogin1(Controler.logged_user);
                    cm.setLogin2(Controler.chat_user);
                    cm.setMsg_date(msgdate);

                    chatdao.open();
                    chatdao.ajouter(cm);
                    chatdao.close();

                    messageAdapteur = new ArrayAdapter<String>(ChatActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, messages);
                    listView.setAdapter(messageAdapteur);

                } else {
                    //On affiche un petit message d'erreur dans un Toast
                    Toast.makeText(ChatActivity.this, "Enter le message", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}