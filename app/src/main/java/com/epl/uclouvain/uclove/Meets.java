package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by delphine on 1/05/2016.
 *
 */
public class Meets extends Activity {
    Button my_meet=null;
    Button new_meet=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meet_interface);
        my_meet = (Button) findViewById(R.id.myRDVsbutton);
        new_meet = (Button) findViewById(R.id.newRDVsbutton);
        my_meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Meets.this, MeetSelectActivity.class);
                startActivity(intent);
            }
        });
        new_meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Meets.this, DisponibilityActivity.class);
                startActivity(intent);
            }
        });
    }

}

