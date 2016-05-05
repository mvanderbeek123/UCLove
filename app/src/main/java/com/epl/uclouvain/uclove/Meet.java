package com.epl.uclouvain.uclove;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by noe on 04/05/16.
 */
public class Meet {
    private String login1;   //toujours voir si login ou id
    private String login2;
    private long date;
    private String lieu;      //voir comment on fonctionne: intervalle d'heures exactes ou à peu près

    public Meet(String login1, String login2, long date, String lieu)
    {
        super();
        this.login1=login1;
        this.login2=login2;
        this.date=date;
        this.lieu=lieu;
    }

    public String getLogin1() {
        return login1;
    }

    public String getLogin2() {
        return login2;
    }

    public long getDate() {
        return date;
    }

    public String getLieu() { return lieu; }

    public void setLogin1(String login1) {
        this.login1 = login1;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setLieu(String lieu) { this.lieu = lieu; }

    public void setLogin2(String login2) { this.login2 = login2; }

    // ajouter les méthodes style comparer disponibilités ?
}
