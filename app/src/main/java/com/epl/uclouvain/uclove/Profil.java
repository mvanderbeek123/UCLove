package com.epl.uclouvain.uclove;

import java.util.Date;

/**
 * Created by marie-marie on 2/05/16.
 */
public class Profil  {
        private String login;
        private String mot_de_passe;
        private String prenom;
        private String nom;
        private Date date_de_naissance;
        private char genre;
        private String etude;
        private String localisation;
        private int numero_de_telephone;
        private String cheveux;
        private String yeux;
        private String peau;
        private String tranche_age;
        private int périmètre;

        public Profil(String login, String mot_de_passe, String prenom, String nom, Date date_de_naissance, char genre, String etude, String localisation)
        {
            this.login=login;
            this.mot_de_passe=mot_de_passe;
            this.prenom=prenom;
            this.nom=nom;
            this.date_de_naissance=date_de_naissance;
            this.genre=genre;
            this.etude=etude;
            this.localisation=localisation;
            //this.numero_de_telephone=null;
            this.cheveux=null;
            this.yeux=null;
            this.peau=null;
            this.tranche_age=null;
            //this.périmètre=null;
        }
        //les geters
        public String getLogin() {return login;}
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
        public String getEtude() {return etude;}
        public String getLocalisation() {return localisation;}
        public int getNumero_de_telephone() {return numero_de_telephone;}
        public String getCheveux() {return cheveux;}
        public String getYeux() {return yeux;}
        public String getPeau() {return peau;}
        public String getTranche_age() {return tranche_age;}
        public int getPérimètre() {return périmètre;}

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

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public void setEtude(String etude) {
        this.etude = etude;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

   //public void setNumero_de_telephone(int numero_de_telephone) {
     //   this.numero_de_telephone = numero_de_telephone;
    //}
    public void setCheveux(String cheveux) {
        this.cheveux = cheveux;
    }

    public void setYeux(String yeux) {
        this.yeux = yeux;
    }

    public void setPeau(String peau) {
        this.peau = peau;
    }

    public void setTranche_age(String tranche_age) {
        this.tranche_age = tranche_age;
    }

    //public void setPérimètre(int périmètre) {
       // this.périmètre = périmètre;
    //}
}
