package com.epl.uclouvain.uclove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CalendarView;

import java.util.Date;

/**
 * Created by noe on 02/05/16.
 */
public class DisponibilityActivity extends Activity {

    CalendarView calendar;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disponibility);

        calendar=(CalendarView) findViewById(R.id.calendarView);
        Date date=new Date(calendar.getDate());

        //Meet m=new Meet(Controler.logged_user, date.getDate(), date.getHours(), date.getHours()+3);
        //MeetDAO.ajouter(m);


    }
}
