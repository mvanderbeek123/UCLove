package com.epl.uclouvain.uclove;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by noe on 04/05/16.
 */
public class Meet {
    private String login;   //toujours voir si login ou id
    private long date;
    private int hourStart;      //voir comment on fonctionne: intervalle d'heures exactes ou à peu près
    private int hourEnd;

    public Meet(String login, long date,int hourStart,int hourEnd)
    {
        super();
        this.login=login;
        this.date=date;
        this.hourStart=hourStart;
        this.hourEnd=hourEnd;
    }

    public String getLogin() {
        return login;
    }

    public long getDate() {
        return date;
    }

    public int getHourStart() { return hourStart; }

    public int getHourEnd() { return hourEnd; }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setHourStart(int hourStart) { this.hourStart = hourStart; }

    public void setHourEnd(int hourEnd) { this.hourEnd = hourEnd; }

    // ajouter les méthodes style comparer disponibilités ?
}
