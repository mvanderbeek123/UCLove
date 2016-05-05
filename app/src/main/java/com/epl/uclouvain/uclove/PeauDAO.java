package com.epl.uclouvain.uclove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

/**
 * Created by marie-marie on 5/05/16.
 */
public class PeauDAO extends DAOBase {

    public static final String PEAU_TABLE_NAME="Peau";
    public static final String PEAU_LOGIN="login";
    public static final String PEAU_COLOR="couleur";

    public PeauDAO(Context pContext)
    {
        super(pContext);
    }

    public void ajouter(Peau a)
    {
        ContentValues value = new ContentValues();
        value.put(PEAU_LOGIN, a.getLogin());
        value.put(PEAU_COLOR, a.getCouleur());
        mDb.insert(PEAU_TABLE_NAME, null, value);
    }

    public void supprimer(Peau a)
    {
    mDb.delete(PEAU_TABLE_NAME, PEAU_LOGIN + " = ? AND " + PEAU_COLOR + " = ?", new String[]{a.getLogin(), a.getCouleur()});
    }

    public void modifier(Peau a, String nouvelleVal)
    {
        ContentValues value = new ContentValues();
        value.put(PEAU_COLOR, nouvelleVal);
        mDb.update(PEAU_TABLE_NAME, value, PEAU_LOGIN + " = ? AND " + PEAU_COLOR + " = ?", new String[]{a.getLogin(), a.getCouleur()});
    }
    public ArrayList<Peau> selectionner(String login)
    {
        Cursor c = mDb.rawQuery("SELECT * FROM " + PEAU_TABLE_NAME + "WHERE " + PEAU_LOGIN + " = ?" , new String[]{login});
        c.moveToFirst();
        ArrayList<Peau> liste = new ArrayList<Peau>();
        while (c.moveToNext())
        {
            String login1 = c.getString(0); ;
            String couleur = c.getString(1);
            Peau a = new Peau(login1 , couleur);
            liste.add(a);
        }
        c.close();
        return liste;
    }
}
