package com.epl.uclouvain.uclove;

/**
 * Created by marie-marie on 5/05/16.
 */
public class Photos {
    private String login;
    private String Nom;
    private boolean profil;

    public Photos(String login,String nom,boolean profil)
    {
        this.login=login;
        this.Nom=nom;
        this.profil=profil;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public boolean isProfil() {
        return profil;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setProfil(boolean profil) {
        this.profil = profil;
    }
}
