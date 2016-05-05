package com.epl.uclouvain.uclove;


import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by marie-marie on 2/05/16.
 */
public class Profil  {
        private String login;
        private String mot_de_passe;
        private String prenom;
        private String nom;
        private Date date_de_naissance;
        private String genre;
        private String etude;
        private int visibilite_etude;
        private String localisation;
        private int visibilite_loc;
        private int numero_de_telephone;
        private int visibilite_num;
        private String cheveux;
        private int visibilite_cheveux;
        private String yeux;
        private int visibilite_yeux;
        private String peau;
        private int visibilite_peau;
        ArrayList<Photos> photo;


        public Profil(String login, String mot_de_passe, String prenom, String nom, Date date_de_naissance, String genre, String etude, String localisation)
        {
            this.login=login;
            this.mot_de_passe=mot_de_passe;
            this.prenom=prenom;
            this.nom=nom;
            this.date_de_naissance=date_de_naissance;
            this.genre=genre;
            this.etude=etude;
            this.visibilite_etude=2;
            this.localisation=localisation;
            this.visibilite_loc=2;
            this.numero_de_telephone=0;
            this.visibilite_num=0;
            this.cheveux=null;
            this.visibilite_cheveux=0;
            this.yeux=null;
            this.visibilite_yeux=0;
            this.peau=null;
            this.visibilite_peau=0;
            photo=new ArrayList<Photos>();
        }
    public Profil(String login, String mot_de_passe, String prenom, String nom, Date date_de_naissance, String genre, String etude, String localisation,String cheveux,String peau,String yeux)
    {
        this.login=login;
        this.mot_de_passe=mot_de_passe;
        this.prenom=prenom;
        this.nom=nom;
        this.date_de_naissance=date_de_naissance;
        this.genre=genre;
        this.etude=etude;
        this.visibilite_etude=2;
        this.localisation=localisation;
        this.visibilite_loc=2;
        this.numero_de_telephone=0;
        this.visibilite_num=0;
        this.cheveux=cheveux;
        this.visibilite_cheveux=2;
        this.yeux=yeux;
        this.visibilite_yeux=2;
        this.peau=peau;
        this.visibilite_peau=2;
    }
        //les geters

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
    public String getGenre() {
        return genre;
    }
    public String getEtude()
    {
        return etude;
    }
    public int getVisibilite_etude() {
        return visibilite_etude;
    }
    public String getLocalisation() {return localisation;}

    public int getVisibilite_loc() {
        return visibilite_loc;
    }
    public int getNumero_de_telephone() {return numero_de_telephone;}

    public int getVisibilite_num() {
        return visibilite_num;
    }
    public String getCheveux() {return cheveux;}

    public int getVisibilite_cheveux() {
        return visibilite_cheveux;
    }
    public String getYeux() {return yeux;}

    public int getVisibilite_yeux() {
        return visibilite_yeux;
    }

    public String getPeau() {return peau;}

    public int getVisibilite_peau() {
        return visibilite_peau;
    }

    //les setters
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setEtude(String etude) {
        this.etude = etude;
    }

    public void setVisibilite_etude(int visibilite_etude) {
        this.visibilite_etude = visibilite_etude;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
        this.visibilite_loc=2;
    }

    public void setVisibilite_loc(int visibilite_loc) {
        this.visibilite_loc = visibilite_loc;
    }

    public void setNumero_de_telephone(int num) {
        this.numero_de_telephone = num;
        this.visibilite_num=2;
    }

    public void setVisibilite_num(int visibilite_num) {
        this.visibilite_num = visibilite_num;
    }

    public void setCheveux(String cheveux) {
        this.cheveux = cheveux;
        this.visibilite_cheveux=2;
    }

    public void setVisibilite_cheveux(int visibilite_cheveux) {
        this.visibilite_cheveux = visibilite_cheveux;
    }

    public void setYeux(String yeux) {
        this.yeux = yeux;
        this.visibilite_yeux=2;
    }

    public void setVisibilite_yeux(int visibilite_yeux) {
        this.visibilite_yeux = visibilite_yeux;
    }

    public void setPeau(String peau) {
        this.peau = peau;
        this.visibilite_peau=2;
    }

    public void setVisibilite_peau(int visibilite_peau) {
        this.visibilite_peau = visibilite_peau;
    }
}
