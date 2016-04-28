package com.epl.uclouvain.uclove;

import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by marie-marie on 28/04/16.
 */
public class Page extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);
        TextView uclove = (TextView) findViewById(R.id.Uclove);
        // On crée un utilitaire de configuration pour cette animation
        Animation animation = AnimationUtils.loadAnimation(this, R.animator.anim);
        // On l'affecte au widget désiré, et on démarre l'animation
        uclove.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {}
            public void onAnimationRepeat(Animation animation) {}
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(Page.this, MainActivity.class);
                startActivity(intent);
            }

        });
    }
}

