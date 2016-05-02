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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by delphine on 02/05/16.
 */
public class ChatActivity extends Activity {
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
        ArrayList<ChatMessage> cmlist = chatdao.historique("user1", "user2"); // TODO
        // TODO convertir cmlist en message et l'assigner ds le listview

        chatdao.close();

        Button btnEnvoie = (Button) findViewById(R.id.envoyer);


        final EditText message = (EditText) findViewById(R.id.message);

        btnEnvoie.setOnClickListener(new OnClickListener() {

            @SuppressWarnings("deprecation")
            public void onClick(View v) {
                String msg = message.getText().toString();
                if (msg.length() > 0) {

                    //SmsManager.getDefault().sendTextMessage(num, null, msg, null, null);
                    // texte devrait etre ajouter dans la base de donnee

                    message.setText("");
                    messages.add("From xx");
                    messages.add("Time");
                    messages.add(msg);
                    messages.add("");

                    // TODO ouvrir l objet chatdao.open()
                    // TODO creer objet chatmessage et le remplir ac toutes les infos
                    // TODO appeler la fonction chatdao.ajouter()
                    // TODO fermer l'objet  chatdao.close()

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
