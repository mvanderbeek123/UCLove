package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by marie-marie on 5/05/16.
 */
public class YeuxDAO extends DAOBase {

    public static final String YEUX_TABLE_NAME="Yeux";
    public static final String YEUX_LOGIN="login";
    public static final String YEUX_COLOR="couleur";

    public YeuxDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Yeux a)
    {
        ContentValues value = new ContentValues();
        value.put(YEUX_LOGIN, a.getLogin());
        value.put(YEUX_COLOR, a.getCouleur());
        mDb.insert(YEUX_TABLE_NAME, null, value);
    }

    public void supprimer(Yeux a)
    {
        mDb.delete(YEUX_TABLE_NAME, YEUX_LOGIN + " = ? AND " + YEUX_COLOR + " = ?", new String[]{a.getLogin(), a.getCouleur()});
    }

    public void modifier(Yeux a, String nouvelleVal)
    {
        ContentValues value = new ContentValues();
        value.put(YEUX_COLOR, nouvelleVal);
        mDb.update(YEUX_TABLE_NAME, value, YEUX_LOGIN + " = ? AND " + YEUX_COLOR + " = ?", new String[]{a.getLogin(), a.getCouleur()});
    }
    public ArrayList<Yeux> selectionner(String login)
    {
        Cursor c = mDb.rawQuery("SELECT * FROM " + YEUX_TABLE_NAME + "WHERE " + YEUX_LOGIN + " = ?" , new String[]{login});
        c.moveToFirst();
        ArrayList<Yeux> liste = new ArrayList<Yeux>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0); ;
            String couleur = c.getString(1);
            Yeux a = new Yeux(login1 , couleur);
            liste.add(a);
        }
        c.close();
        return liste;
    }
}
