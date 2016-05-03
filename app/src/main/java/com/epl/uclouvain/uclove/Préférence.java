package com.epl.uclouvain.uclove;

import java.util.Date;

/**
 * Created by marie-marie on 4/05/16.
 */
public class Préférence {

    private char genre;
    private String etude;
    private int perimetre;
    private String cheveux;
    private String yeux;
    private String peau;
    private int agemax;
    private int agemin;

    public Préférence (char genre,String etude, int perimetre, String cheveux, String yeux, String peau, int agemax, int agemin)
    {
        this.genre=genre;
        this.etude=etude;
        this.perimetre=perimetre;
        this.cheveux=cheveux;
        this.yeux=yeux;
        this.peau=peau;
        this.agemax=agemax;
        this.agemin=agemin;
    }


}
