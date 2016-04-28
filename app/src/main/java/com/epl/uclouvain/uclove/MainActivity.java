package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnTouchListener{

    private TextView text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button connecter = (Button) findViewById(R.id.connecter);
        Button inscription = (Button) findViewById(R.id.inscription);
        // On l'affecte au widget désiré, et on démarre l'animation
        inscription.setOnTouchListener(this);
        // Puis on lui indique que cette classe sera son listener pour l'évènement Touch
        connecter.setOnTouchListener(this);
    }


    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // Comme l'évènement nous donne la vue concernée par le toucher, on le récupère et on le caste en Button
        Button boutonpremier = (Button) view;
        Intent intent = new Intent(MainActivity.this, PageAcceuil.class);
        startActivity(intent);
        return true;
    }
}
