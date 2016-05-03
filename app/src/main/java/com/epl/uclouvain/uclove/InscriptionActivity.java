package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by marie-marie on 2/05/16.
 */
public class InscriptionActivity extends Activity {
    private static int compteur=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        Button valider = (Button) findViewById(R.id.comptecreation);
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comptecreation();
                //Intent intent = new Intent(this, ProfilActivity.class);
                //startActivity(intent);
            }
        });
    }
    if (compteur==1)
    {
        //création de la base de données
        //DataBase a= new DataBase(this, "database",NULL,1)
    }
    public void comptecreation()
}
