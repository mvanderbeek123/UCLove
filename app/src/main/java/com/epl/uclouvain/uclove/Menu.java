package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by marie-marie on 28/04/16.
 */
public class Menu extends Activity {
    private Button profil = null;
    private Button preference = null;
    private Button people = null;
    private Button friends= null;
    private Button requests = null;
    private Button chat = null;
    private Button meet = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        profil = (Button) findViewById(R.id.Profil);
        preference = (Button) findViewById(R.id.Preference);
        people = (Button) findViewById(R.id.People);
        friends= (Button) findViewById(R.id.Friends);
        requests = (Button) findViewById(R.id.Requests);
        chat = (Button) findViewById(R.id.Chat);
        meet = (Button) findViewById(R.id.Meet);
        // Puis on lui indique que cette classe sera son listener pour l'évènement Touch
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
        preference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ProfilActivity.class);
                startActivity(intent);
            }
        });
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, FriendsActivity.class);
                startActivity(intent);
            }
        });
        requests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Requests.class);
                startActivity(intent);
            }
        });
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ChatActivity.class);
                startActivity(intent);
            }
        });
        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, MeetActivity.class);
                startActivity(intent);
            }
        });
    }

}
