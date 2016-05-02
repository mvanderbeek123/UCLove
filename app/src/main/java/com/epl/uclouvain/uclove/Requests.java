package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Steph on 1/05/2016.
 * Activité qui nous laisse le choix de consulter nos demandes d'amis ou d'en créé une nouvelle.
 */
public class Requests extends Activity {
    Button my_request=null;
    Button new_request=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.requests_interface);
        my_request = (Button) findViewById(R.id.myRequestsbutton);
        new_request = (Button) findViewById(R.id.newRequestsbutton);
        my_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Requests.this, MyRequests.class);
                startActivity(intent);
            }
        });
        new_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Requests.this, NewRequest.class);
                startActivity(intent);
            }
        });
    }

}

