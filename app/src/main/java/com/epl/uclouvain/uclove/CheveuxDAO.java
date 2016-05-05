package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by marie-marie on 5/05/16.
 */
public class CheveuxDAO extends DAOBase{

    public static final String CHEVEUX_TABLE_NAME="Cheveux";
    public static final String CHEVEUX_LOGIN="login";
    public static final String CHEVEUX_COLOR="couleur";

    public CheveuxDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Cheveux a)
    {
        ContentValues value = new ContentValues();
        value.put(CHEVEUX_LOGIN, a.getLogin());
        value.put(CHEVEUX_COLOR, a.getCouleur());
        mDb.insert(CHEVEUX_TABLE_NAME, null, value);
    }

    public void supprimer(Cheveux a)
    {
        mDb.delete(CHEVEUX_TABLE_NAME, CHEVEUX_LOGIN + " = ? AND " + CHEVEUX_COLOR + " = ?", new String[]{a.getLogin(), a.getCouleur()});
    }

    public void modifier(Cheveux a, String nouvelleVal)
    {
        ContentValues value = new ContentValues();
        value.put(CHEVEUX_COLOR, nouvelleVal);
        mDb.update(CHEVEUX_TABLE_NAME, value, CHEVEUX_LOGIN + " = ? AND " + CHEVEUX_COLOR + " = ?", new String[]{a.getLogin(), a.getCouleur()});
    }
    public ArrayList<Cheveux> selectionner(String login)
    {
        Cursor c = mDb.rawQuery("SELECT * FROM " + CHEVEUX_TABLE_NAME + "WHERE " + CHEVEUX_LOGIN + " = ?" , new String[]{login});
        c.moveToFirst();
        ArrayList<Cheveux> liste = new ArrayList<Cheveux>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0); ;
            String couleur = c.getString(1);
            Cheveux a = new Cheveux(login1 , couleur);
            liste.add(a);
        }
        c.close();
        return liste;
    }
}
