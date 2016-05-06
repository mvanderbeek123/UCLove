package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button connecter = (Button) findViewById(R.id.connecter);
        Button inscription = (Button) findViewById(R.id.inscription);
        // On l'affecte au widget désiré, et on démarre l'animation
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);
            }
        });
        // Puis on lui indique que cette classe sera son listener pour l'évènement Touch
        connecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PageAcceuil.class);
                startActivity(intent);
            }
        });
    }
}
