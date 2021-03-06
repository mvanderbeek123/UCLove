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
        mDb.update(CLIENT_TABLE_NAME, value, CLIENT_LOGIN + " = ?", new String[]{a.getLogin()});

    }

    public Profil selectionner(String login){
        Cursor c = mDb.rawQuery("select " + "*" + " from " + CLIENT_TABLE_NAME + " where " + CLIENT_LOGIN + " = ?", new String[]{login});
        c.moveToFirst();
        String log = c.getString(0);
        String mdp = c.getString(1);
        String name  = c.getString(2);
        String lastname= c.getString(3);
        String date=c.getString(4);
        Date date1=Date.valueOf(date);
        String genre=c.getString(5);
        String etude=c.getString(6);
        String place=c.getString(7);
        String num=c.getString(8);
        String cheveux=c.getString(9);
        String peau=c.getString(10);
        String yeux=c.getString(11);
        Profil a = new Profil(log,mdp,name,lastname, date1,genre,etude,place,cheveux,peau,yeux);
        c.close();
        return a;
    }
    public ArrayList<String> selectionnerAleatoire(String log){
        Cursor c = mDb.rawQuery("select " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME + " WHERE " + CLIENT_LOGIN +" IS NOT ?",new String[]{log});
        c.moveToFirst();
        ArrayList<String> liste=new ArrayList<>();
        while (c.isAfterLast() == false) {
            String login = c.getString(0);
            liste.add(login);
            c.moveToNext();
        }
        c.close();
        return liste;
    }
    public boolean identifier(String login, String mdp)
    {
        Cursor c=mDb.rawQuery("SELECT COUNT(*) from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_LOGIN + " = ? AND " + CLIENT_MDP + " = ? ", new String[]{login, mdp});
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        if (i>=1)
        {
            return true;
        }
        else {return false;}
    }
    public boolean existant(String login)
    {
        Cursor c=mDb.rawQuery("SELECT COUNT(*) from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_LOGIN + " = ?", new String[]{login});
        c.moveToFirst();
        int i = c.getInt(0);
        c.close();
        if (i==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ArrayList<String> filtreCheveux (String cheveux)
    {
        Cursor c=mDb.rawQuery("SELECT " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_HAIR + " = ?", new String[]{cheveux});
        c.moveToFirst();
        ArrayList<String> liste = new ArrayList<String>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0);
            liste.add(login1);
        }
        c.close();
        return liste;
    }
    public ArrayList<String> filtreGenre (String genre)
    {
        Cursor c=mDb.rawQuery("SELECT " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_GENRE + " = ?", new String[]{genre});
        c.moveToFirst();
        ArrayList<String> liste = new ArrayList<String>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0);
            liste.add(login1);
        }
        c.close();
        return liste;
    }
    public ArrayList<String> filtreYeux (String yeux)
    {
        Cursor c=mDb.rawQuery("SELECT " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_EYES + " = ?", new String[]{yeux});
        c.moveToFirst();
        ArrayList<String> liste = new ArrayList<String>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0);
            liste.add(login1);
        }
        c.close();
        return liste;
    }
    public ArrayList<String> filtreEtude (String etude)
    {
        Cursor c=mDb.rawQuery("SELECT " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_ETUDE + " = ?", new String[]{etude});
        c.moveToFirst();
        ArrayList<String> liste = new ArrayList<String>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0);
            liste.add(login1);
        }
        c.close();
        return liste;
    }
    public ArrayList<String> filtrePeau (String peau)
    {
        Cursor c=mDb.rawQuery("SELECT " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_SKIN + " = ?", new String[]{peau});
        c.moveToFirst();
        ArrayList<String> liste = new ArrayList<String>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0);
            liste.add(login1);
        }
        c.close();
        return liste;
    }
    public ArrayList<String> filtreLocalisation (String localisation)
    {
        Cursor c=mDb.rawQuery("SELECT " + CLIENT_LOGIN + " from " + CLIENT_TABLE_NAME +
                " where " + CLIENT_PLACE + " = ?", new String[]{localisation});
        c.moveToFirst();
        ArrayList<String> liste = new ArrayList<String>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0);
            liste.add(login1);
        }
        c.close();
        return liste;
    }
}
