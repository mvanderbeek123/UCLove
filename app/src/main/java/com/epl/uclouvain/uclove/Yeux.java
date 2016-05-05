package com.epl.uclouvain.uclove;

/**
 * Created by marie-marie on 5/05/16.
 */
public class Yeux {
    private String login;
    private String couleur;

    public Yeux (String login,String couleur)
    {
        this.login=login;
        this.couleur=couleur;
    }
    public String getLogin() {
        return login;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
