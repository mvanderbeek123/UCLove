package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by marie-marie on 21/04/16.
 */
public class PageAcceuil extends Activity implements View.OnTouchListener{
    boolean bool;
    boolean bool2;
    private ProfilDAO profildao;
    EditText login;
    EditText mdp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageacceuil);
        Button b = (Button) findViewById(R.id.connexion);
        login=(EditText) findViewById(R.id.Login);
        mdp= (EditText) findViewById(R.id.motdepasse);
        b.setOnTouchListener(this);
    }

    // Fonction qui sera lancée à chaque fois qu'un toucher est détecté sur le bouton rattaché
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        profildao=new ProfilDAO(this);
        String log=login.getText().toString();
        String motdepasse=mdp.getText().toString();
        profildao.open();
        bool = profildao.identifier(log,motdepasse);
        bool2 = profildao.existant(log);
        profildao.close();
        if (bool==true) {
            Controler.logged_user = log;
            Intent intent = new Intent(PageAcceuil.this, Menu.class);
            intent.putExtra("login",log);
            startActivity(intent);
            return true;
        }
        else if(bool2==true){

            Toast toast=Toast.makeText(getApplicationContext(),"Mot de passe incorrect",Toast.LENGTH_LONG);
            toast.show();
            return true;
        }
        else
        {
            Toast toast=Toast.makeText(getApplicationContext(),"Login inexistant",Toast.LENGTH_LONG);
            toast.show();
            return true;
        }

    }
}
