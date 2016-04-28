package com.epl.uclouvain.uclove;

import java.util.Date;

/**
 * Created by marie-marie on 28/04/16.
 */
public class Identification {
        private String login;
        private String mot_de_passe;
        private String prenom;
        private String nom;
        private Date date_de_naissance;
        private char genre;

    public Identification(String login, String mot_de_passe, String prenom, String nom, Date date_de_naissance, char genre)
    {
        this.login=login;
        this.mot_de_passe=mot_de_passe;
        this.prenom=prenom;
        this.nom=nom;
        this.date_de_naissance=date_de_naissance;
        this.genre=genre;
    }
    public String getLogin()
    {
        return login;
    }
    public String getMot_de_passe() {
        return mot_de_passe;
    }
    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }
    public char getGenre() {
        return genre;
    }
}
