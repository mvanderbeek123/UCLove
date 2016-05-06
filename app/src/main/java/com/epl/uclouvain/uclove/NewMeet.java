package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by delphine on 06/05/16.
 */
public class NewMeet extends Activity {
    Button envoie;
    EditText lieu;
    EditText date_rdv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newmeet);

        envoie = (Button) findViewById(R.id.button);
        lieu = (EditText) findViewById(R.id.lieu);
        date_rdv = (EditText) findViewById(R.id.date);

        envoie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //TODO rencontrer
                Controler.rdv_lieu = lieu.getText().toString();
                Controler.rdv_date = date_rdv.getText().toString();
                Intent intent = new Intent(NewMeet.this, MeetSelectActivity.class);
                startActivity(intent);
            }
        });

    }
}
