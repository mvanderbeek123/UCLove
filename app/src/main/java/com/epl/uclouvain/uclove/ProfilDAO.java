package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

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
    public static final String CLIENT_AGE="tranche_age";
    public static final String CLIENT_LOC="perimetre";

    public ProfilAO(Context pContext)
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
        value.put(ProfilDAO.CLIENT_DATE, a.getDate_de_naissance());
        value.put(ProfilDAO.CLIENT_GENRE, a.getGenre());
        value.put(ProfilDAO.CLIENT_ETUDE, a.getEtude());
        value.put(ProfilDAO.CLIENT_PLACE, a.getLocalisation());
        value.put(ProfilDAO.CLIENT_NUM, a.getNumero_de_telephone());
        value.put(ProfilDAO.CLIENT_HAIR, a.getCheveux());
        value.put(ProfilDAO.CLIENT_EYES, a.getYeux());
        value.put(ProfilDAO.CLIENT_SKIN, a.getPeau());
        value.put(ProfilDAO.CLIENT_AGE, a.getTranche_age());
        value.put(ProfilDAO.CLIENT_LOC, a.getPérimètre());
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
    public Profil selectionner(String login){
        Cursor c = mDb.rawQuery("select " + "*" + " from " + CLIENT_TABLE_NAME + " where" + CLIENT_LOGIN + "= ?", new String[]{login});
    }


}
