package com.epl.uclouvain.uclove;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by noe on 04/05/16.
 */
public class Meet {
    private String login;   //toujours voir si login ou id
    private Date date;
    private Time hour;      //voir comment on fonctionne: intervalle d'heures exactes ou à peu près

    public Meet(String login, Date date,Time hour)
    {
        super();
        this.login=login;
        this.date=date;
        this.hour=hour;
    }

    public String getLogin() {
        return login;
    }

    public Date getDate() {
        return date;
    }

    public Time getHour() {
        return hour;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    // ajouter les méthodes style comparer disponibilités ?
}
