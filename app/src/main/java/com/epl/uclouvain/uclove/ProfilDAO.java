package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by marie-marie on 3/05/16.
 */
public class ProfilDAO extends DAOBase {

    public static final String CLIENT_TABLE_NAME="Client";
    public static final String CLIENT_LOGIN="login";
    public static final String CLIENT_MDP="mot_de_passe";
    public static final String CLIENT_NAME="prenom";
    public static final String CLIENT_LASTNAME="nom";
    public static final String CLIENT_DATE="date_de_naissance";
    public static final String CLIENT_GENRE="genre";
    public static final String CLIENT_ETUDE="etude";
    public static final String CLIENT_PLACE="localisation";
    public static final String CLIENT_NUM="numero_de_telephone";
    public static final String CLIENT_HAIR="cheveux";
    public static final String CLIENT_EYES="yeux";
    public static final String CLIENT_SKIN="peau";

    public ProfilDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Profil a)
    {
        ContentValues value = new ContentValues();
        value.put(ProfilDAO.CLIENT_LOGIN, a.getLogin());
        value.put(ProfilDAO.CLIENT_MDP, a.getMot_de_passe());
        value.put(ProfilDAO.CLIENT_NAME, a.getPrenom());
        value.put(ProfilDAO.CLIENT_LASTNAME, a.getNom());
        value.put(ProfilDAO.CLIENT_DATE, a.getDate_de_naissance().toString());
        value.put(ProfilDAO.CLIENT_GENRE, a.getGenre());
        value.put(ProfilDAO.CLIENT_ETUDE, a.getEtude());
        value.put(ProfilDAO.CLIENT_PLACE, a.getLocalisation());
        value.put(ProfilDAO.CLIENT_NUM, a.getNumero_de_telephone());
        value.put(ProfilDAO.CLIENT_HAIR, a.getCheveux());
        value.put(ProfilDAO.CLIENT_EYES, a.getYeux());
        value.put(ProfilDAO.CLIENT_SKIN, a.getPeau());
        mDb.insert(ProfilDAO.CLIENT_TABLE_NAME, null, value);
    }

    public void supprimer(String login)
    {
        mDb.delete(CLIENT_TABLE_NAME, CLIENT_LOGIN + " = ?", new String[]{login});
    }
    public void modifier_motdepasse(Profil a)
    {
        ContentValues value = new ContentValues();
        value.put(CLIENT_MDP, a.getMot_de_passe());
        mDb.update(CLIENT_TABLE_NAME, value, CLIENT_LOGIN + " = ?", new String[]{a.getLogin()});
    }
    //met a jour les Nom, prénom, date, genre, ...
    public void modifier(Profil a)
    {
        ContentValues value = new ContentValues();
        //value.put(Colonne, a.getSalaire());
        mDb.update(CLIENT_TABLE_NAME, value, CLIENT_LOGIN + " = ?", new String[]{a.getLogin()});

    }
    public Profil selectionner(String login2){
        Cursor c = mDb.rawQuery("select " + "*" + " from " + CLIENT_TABLE_NAME + " where" + CLIENT_LOGIN + "= ?", new String[]{login2});
        String login = c.getString(1);
        String mdp = c.getString(2);
        String name  = c.getString(3);
        String lastname= c.getString(4);
        String date=c.getString(5);
        Date date1=Date.valueOf(date);
        String genre=c.getString(6);
        String etude=c.getString(7);
        String place=c.getString(8);
        int num=c.getInt(9);
        String cheveux=c.getString(10);
        String peau=c.getString(11);
        String yeux=c.getString(12);
        Profil a = new Profil(login,mdp,name,lastname,date1,genre,etude,place,cheveux,peau,yeux);
        c.close();
        return a;
    }
    public boolean identifier(String login, String mdp)
    {
        Cursor c=mDb.rawQuery("select " + "COUNT(*)" + " from " + CLIENT_TABLE_NAME + " where" + CLIENT_LOGIN + "= ?" + "AND" + CLIENT_MDP + "=?", new String[]{login,mdp});
        if (c.getInt(0)==1){
            return true;
        }
        else {return false;}
    }
}
