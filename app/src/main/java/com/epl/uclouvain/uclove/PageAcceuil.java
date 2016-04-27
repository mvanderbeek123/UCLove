package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by marie-marie on 21/04/16.
 */
public class PageAcceuil extends Activity implements View.OnTouchListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageacceuil);
        Button b = (Button) findViewById(R.id.connexion);
        // Puis on lui indique que cette classe sera son listener pour l'évènement Touch
        b.setOnTouchListener(this);
    }

    // Fonction qui sera lancée à chaque fois qu'un toucher est détecté sur le bouton rattaché
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // Comme l'évènement nous donne la vue concernée par le toucher, on le récupère et on le caste en Button
        Button bouton = (Button)view;
        bouton.setBackgroundColor(1);
        return true;
    }
}