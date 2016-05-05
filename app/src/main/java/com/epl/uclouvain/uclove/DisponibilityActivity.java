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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by noe on 02/05/16.
 */
public class DisponibilityActivity extends Activity implements View.OnTouchListener{

    CalendarView calendarView;
    TextView dateDisplay;
    EditText hourStart;
    EditText hourEnd;
    private MeetDAO meetdao;
    Meet m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disponibility);

        Button b=(Button) findViewById(R.id.button);
        hourStart=(EditText) findViewById(R.id.editText);
        hourEnd= (EditText) findViewById(R.id.editText2);
        b.setOnTouchListener(this);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateDisplay = (TextView) findViewById(R.id.textView);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                dateDisplay.setText("Date: " + day + " / " + month + " / " + year);

                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + day + "\n" + "Month = " + month + "\n" + "Year = " + year, Toast.LENGTH_LONG).show();
                long time=calendarView.getDate();
                m=new Meet(Controler.logged_user,time,0,0);
            }
        });
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        m.setHourStart(hourStart.getInputType());
        m.setHourEnd(hourEnd.getInputType());
        meetdao=new MeetDAO(getApplicationContext());
        meetdao.open();
        meetdao.ajouter(m);
        meetdao.close();
        return true;
    }

}

    /*CalendarView calendar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disponibility);
        initializeCalendar();
    }

    public void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendarView);
        calendar.setShowWeekNumber(false);
        //lundi 1er jour de la semaine
        calendar.setFirstDayOfWeek(2);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
            }
        });
    }


        //calendar=(CalendarView) findViewById(R.id.calendarView);
        //Date date=new Date(calendar.getDate());

        //Meet m=new Meet(Controler.logged_user, date.getDate(), date.getHours(), date.getHours()+3);
        //MeetDAO.ajouter(m);



}*/
